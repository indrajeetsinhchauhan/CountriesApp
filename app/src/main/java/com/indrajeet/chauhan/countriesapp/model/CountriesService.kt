package com.indrajeet.chauhan.countriesapp.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService {
    private val BASE_URL = "https://raw.githubusercontent.com"

    private val api:CountriesApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountriesApi::class.java)

    suspend fun getCountries(): List<CountryModel> {
        return api.getCountries()
    }

    companion object {
        @Volatile
        private var instance: CountriesService? = null

        fun getInstance(): CountriesService {
            return instance ?: synchronized(this) {
                instance ?: CountriesService().also { instance = it }
            }
        }
    }
}