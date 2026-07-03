package com.ortalesoft.letsshop.data.local_storage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class UserStorage(context: Context) {
    companion object {
        private const val PREF_NAME = "user_profile"

        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_EMAIL = "email"
    }

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveUser(
        id: String,
        name: String,
        email: String
    ) {
        prefs.edit {
            putString(KEY_ID, id)
                .putString(KEY_NAME, name)
                .putString(KEY_EMAIL, email)
        }
    }

    fun getId(): String? = prefs.getString(KEY_ID, null)

    fun getName(): String? = prefs.getString(KEY_NAME, null)

    fun getEmail(): String? = prefs.getString(KEY_EMAIL, null)

    fun clear() {
        prefs.edit {
            clear()
        }
    }
}