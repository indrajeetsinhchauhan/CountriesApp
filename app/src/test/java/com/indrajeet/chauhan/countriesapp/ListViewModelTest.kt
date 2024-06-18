package com.indrajeet.chauhan.countriesapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.indrajeet.chauhan.countriesapp.model.CountriesService
import com.indrajeet.chauhan.countriesapp.model.CountryModel
import com.indrajeet.chauhan.countriesapp.viewmodel.ListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ListViewModelTest {

    @get:Rule
    val rule  = InstantTaskExecutorRule()

    private lateinit var listViewModel:ListViewModel

    @Mock
    private lateinit var countriesService: CountriesService

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        listViewModel = ListViewModel().apply {
            countriesService = this@ListViewModelTest.countriesService
        }
    }

    @Test
    fun getCountriesSuccess() = runBlocking {
        val countryModel = CountryModel("CountryName", "CountryCapital", "CountryFlag")
        val countryList = listOf(countryModel)

        `when`(countriesService.getCountries()).thenReturn(countryList)

        val countriesObserver = Observer<List<CountryModel>> {}
        val errorObserver = Observer<Boolean> {}
        val loadingObserver = Observer<Boolean> {}
        try {
            listViewModel.countries.observeForever(countriesObserver)
            listViewModel.countryLoadError.observeForever(errorObserver)
            listViewModel.loading.observeForever(loadingObserver)

            listViewModel.refresh()

            assertEquals(1, listViewModel.countries.value?.size)
            assertEquals(false, listViewModel.countryLoadError.value)
            assertEquals(false, listViewModel.loading.value)
        } finally {
            listViewModel.countries.removeObserver(countriesObserver)
            listViewModel.countryLoadError.removeObserver(errorObserver)
            listViewModel.loading.removeObserver(loadingObserver)
        }
    }
}