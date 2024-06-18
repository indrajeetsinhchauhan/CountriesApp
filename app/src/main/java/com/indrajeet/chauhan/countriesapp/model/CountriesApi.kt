package com.indrajeet.chauhan.countriesapp.model

import retrofit2.http.GET

interface CountriesApi {

    @GET("DevTides/countries/master/countriesV2.json")
    suspend fun getCountries() : List<CountryModel>
}