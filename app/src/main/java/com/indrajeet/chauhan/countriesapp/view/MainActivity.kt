package com.indrajeet.chauhan.countriesapp.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.indrajeet.chauhan.countriesapp.R
import com.indrajeet.chauhan.countriesapp.viewmodel.ListViewModel

class MainActivity : ComponentActivity() {

    lateinit var countryList: RecyclerView
    lateinit var listError: TextView
    lateinit var loadingView: ProgressBar
    lateinit var refreshLayout: SwipeRefreshLayout
    lateinit var listViewModel: ListViewModel
    var adapter: CountryListAdapter = CountryListAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countryList = findViewById<RecyclerView>(R.id.countriesList)
        listError = findViewById<TextView>(R.id.list_error)
        loadingView = findViewById<ProgressBar>(R.id.loading_view)
        refreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)

        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        listViewModel.refresh()

        countryList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        countryList.adapter = adapter

        refreshLayout.setOnRefreshListener {
            listViewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        listViewModel.countries.observe(this) { countryModels ->
            if (countryModels != null) {
                countryList.visibility = View.VISIBLE
                adapter.updateCountries(countryModels)
            }
        }
        listViewModel.loading.observe(this) { isError ->
            if (isError != null) {
                listError.visibility = if (isError) View.VISIBLE else View.GONE
            }
        }
        listViewModel.countryLoadError.observe(this) { isLoading ->
            if (isLoading != null) {
                loadingView.visibility = if (isLoading) View.VISIBLE else View.GONE
                if (isLoading) {
                    listError.visibility = View.GONE
                    countryList.visibility = View.GONE
                }
            }
        }
    }
}