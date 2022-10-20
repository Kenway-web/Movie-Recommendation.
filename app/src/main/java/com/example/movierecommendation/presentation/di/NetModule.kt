package com.example.movierecommendation.presentation.di

import com.example.movierecommendation.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        //will construct Retrofit instance call and Return it
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    fun provideTMDBService(retrofit: Retrofit):TMDBService{
        return  retrofit.create(TMDBService::class.java)
    }
}