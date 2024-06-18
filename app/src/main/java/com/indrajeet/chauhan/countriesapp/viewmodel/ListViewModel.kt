package com.indrajeet.chauhan.countriesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indrajeet.chauhan.countriesapp.model.CountriesService
import com.indrajeet.chauhan.countriesapp.model.CountryModel
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    val countries = MutableLiveData<List<CountryModel>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    private val countriesService = CountriesService.getInstance()

    fun refresh() {
        fetchCountries()
    }

//    fun fetchCountries() {
//        val country1 = CountryModel("Albania", "Tirana", "")
//        val country2 = CountryModel("Brazil", "Brasilia", "")
//        val country3 = CountryModel("Czechia", "Praha", "")
//
//        val list = ArrayList<CountryModel>()
//        list.add(country1)
//        list.add(country2)
//        list.add(country3)
//
//        countries.value = list
//        countryLoadError.value = false
//        loading.value = false
//    }

    private fun fetchCountries() {
        viewModelScope.launch {
            try {
                val countryModels = countriesService.getCountries()
                countries.postValue(countryModels)
                countryLoadError.postValue(false)
                loading.postValue(false)
            } catch (throwable: Throwable) {
                countryLoadError.postValue(true)
                loading.postValue(false)
                throwable.printStackTrace()
            }
        }
    }
}