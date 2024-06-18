package com.indrajeet.chauhan.countriesapp.di

import com.indrajeet.chauhan.countriesapp.model.CountriesService
import dagger.Component

//Need to use this class is you want to do dependency injection
// We have to use this class in the CountriesService class as DaggerApiComponent but it is not
// working so for now, I have postponed dependency injection
@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(countriesService: CountriesService)
}