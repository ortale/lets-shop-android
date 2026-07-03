package com.ortalesoft.letsshop.di

import com.ortalesoft.letsshop.data.common.Constants
import com.ortalesoft.letsshop.data.remote.LetsShopApi
import com.ortalesoft.letsshop.data.repository.ShoppingListRepositoryImpl
import com.ortalesoft.letsshop.data.repository.SignInRepositoryImpl
import com.ortalesoft.letsshop.data.repository.SignUpRepositoryImpl
import com.ortalesoft.letsshop.domain.repository.ShoppingListRepository
import com.ortalesoft.letsshop.domain.repository.SignInRepository
import com.ortalesoft.letsshop.domain.repository.SignUpRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLetsShopApi(): LetsShopApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
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
    fun provideSignInRepository(api: LetsShopApi): SignInRepository {
        return SignInRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSignUpRepository(api: LetsShopApi): SignUpRepository {
        return SignUpRepositoryImpl(api)
    }
}