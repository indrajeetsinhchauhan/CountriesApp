package com.indrajeet.chauhan.countriesapp.di

import com.indrajeet.chauhan.countriesapp.model.CountriesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Need to use this class is you want to do dependency injection
@Module
class ApiModule {
    private val BASE_URL = "https://raw.githubusercontent.com"

    @Provides
    fun provideCountriesApi() : CountriesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }
}