package com.example.e_commerceapplication.di

import com.example.e_commerceapplication.common.Constants
import com.example.e_commerceapplication.data.service.CommerceApi
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
    fun getRetrofitServiceInstance(retrofit: Retrofit): CommerceApi{
        return retrofit.create(CommerceApi::class.java)
    }
    @Provides
    @Singleton
    fun getClientApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}