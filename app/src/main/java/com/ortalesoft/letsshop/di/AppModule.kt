package com.ortalesoft.letsshop.di

import com.ortalesoft.letsshop.data.common.Constants
import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.data.repository.ShoppingListRepositoryImpl
import com.ortalesoft.letsshop.data.repository.AuthRepositoryImpl
import com.ortalesoft.letsshop.domain.repository.ShoppingListRepository
import com.ortalesoft.letsshop.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLetsShopApi(): LetsShopApi {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
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
    fun authRepository(api: LetsShopApi): AuthRepository {
        return AuthRepositoryImpl(api)
    }
}