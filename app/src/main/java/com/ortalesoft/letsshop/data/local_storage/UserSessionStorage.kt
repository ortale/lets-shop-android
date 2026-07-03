package com.ortalesoft.letsshop.data.local_storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.util.Base64
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_session")

@Singleton
class UserSessionStorage @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private const val KEYSET_NAME = "user_session_keyset"
        private const val PREF_FILE_NAME = "user_session_keyset_prefs"
        private const val MASTER_KEY_URI = "android-keystore://user_session_master_key"

        private val KEY_TOKEN = stringPreferencesKey("jwt_token")
        private val KEY_ID = stringPreferencesKey("user_id")
        private val KEY_NAME = stringPreferencesKey("user_name")
        private val KEY_EMAIL = stringPreferencesKey("user_email")
    }

    // Tink AEAD (Authenticated Encryption with Associated Data)
    // Keys are stored in Android Keystore — never leave the device
    private val aead: Aead by lazy {
        AeadConfig.register()
        AndroidKeysetManager.Builder()
            .withSharedPref(context, KEYSET_NAME, PREF_FILE_NAME)
            .withKeyTemplate(KeyTemplates.get("AES256_GCM"))
            .withMasterKeyUri(MASTER_KEY_URI)
            .build()
            .keysetHandle
            .getPrimitive(Aead::class.java)
    }

    private fun encrypt(value: String): String {
        val ciphertext = aead.encrypt(value.toByteArray(), null)
        return Base64.getEncoder().encodeToString(ciphertext)
    }

    private fun decrypt(value: String): String {
        val decoded = Base64.getDecoder().decode(value)
        return String(aead.decrypt(decoded, null))
    }

    // ── Token ──────────────────────────────────────────────────────────────

    suspend fun saveToken(token: String) {
        context.dataStore.edit { it[KEY_TOKEN] = encrypt(token) }
    }

    suspend fun getToken(): String? =
        context.dataStore.data.map { prefs ->
            prefs[KEY_TOKEN]?.let { decrypt(it) }
        }.first()

    suspend fun getBearerToken(): String? = getToken()?.let { "Bearer $it" }

    suspend fun isLoggedIn(): Boolean = getToken() != null

    // ── User data ──────────────────────────────────────────────────────────

    suspend fun saveUser(id: String, name: String, email: String) {
        context.dataStore.edit { prefs ->
            prefs[KEY_ID] = encrypt(id)
            prefs[KEY_NAME] = encrypt(name)
            prefs[KEY_EMAIL] = encrypt(email)
        }
    }

    suspend fun getUserId(): String? =
        context.dataStore.data.map { it[KEY_ID]?.let { v -> decrypt(v) } }.first()

    suspend fun getUserName(): String? =
        context.dataStore.data.map { it[KEY_NAME]?.let { v -> decrypt(v) } }.first()

    suspend fun getUserEmail(): String? =
        context.dataStore.data.map { it[KEY_EMAIL]?.let { v -> decrypt(v) } }.first()

    // ── Clear all (sign out) ───────────────────────────────────────────────

    suspend fun clear() {
        context.dataStore.edit { it.clear() }
    }
}