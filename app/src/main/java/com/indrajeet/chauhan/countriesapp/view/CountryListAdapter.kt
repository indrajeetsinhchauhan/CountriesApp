package com.indrajeet.chauhan.countriesapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.indrajeet.chauhan.countriesapp.R
import com.indrajeet.chauhan.countriesapp.model.CountryModel

class CountryListAdapter(val countryList: MutableList<CountryModel>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    var countries: MutableList<CountryModel> = countryList

    fun updateCountries(countryList: List<CountryModel>) {
        countries.clear()
        countries.addAll(countryList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var countryImage: ImageView

        lateinit var countryName: TextView

        lateinit var countryCapital: TextView

        fun bind(countryModel: CountryModel) {
            countryImage = itemView.findViewById(R.id.image_view)
            countryName = itemView.findViewById(R.id.name)
            countryCapital = itemView.findViewById(R.id.capital)

            countryName.text = countryModel.name
            countryCapital.text = countryModel.capital
            Util.loadImage(countryImage, countryModel.flagPNG, Util.getProgressDrawable(countryImage.context))
        }

    }
}