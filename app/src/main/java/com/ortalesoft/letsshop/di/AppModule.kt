package com.ortalesoft.letsshop.di

import com.ortalesoft.letsshop.data.common.Constants
import com.ortalesoft.letsshop.data.local_storage.UserSessionStorage
import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.data.repository.ShoppingListRepositoryImpl
import com.ortalesoft.letsshop.data.repository.AuthRepositoryImpl
import com.ortalesoft.letsshop.domain.repository.ShoppingListRepository
import com.ortalesoft.letsshop.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.ortalesoft.letsshop.BuildConfig
import kotlinx.coroutines.runBlocking

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLetsShopApi(userSessionStorage: UserSessionStorage): LetsShopApi {
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }

        val authInterceptor = Interceptor { chain ->
            val token = runBlocking { userSessionStorage.getBearerToken() }
            val request = token?.let {
                chain.request().newBuilder()
                    .addHeader("Authorization", it)
                    .build()
            } ?: chain.request()
            chain.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LetsShopApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShoppingListRepository(api: LetsShopApi): ShoppingListRepository {
        return ShoppingListRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun authRepository(api: LetsShopApi, sessionStorage: UserSessionStorage): AuthRepository {
        return AuthRepositoryImpl(api, sessionStorage)
    }
}