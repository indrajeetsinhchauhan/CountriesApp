package com.indrajeet.chauhan.countriesapp.view

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indrajeet.chauhan.countriesapp.R

class Util {

    companion object {
        fun loadImage(imageView: ImageView, url: String, progressDrawable: CircularProgressDrawable) {
            val option: RequestOptions =
                RequestOptions()
                    .placeholder(progressDrawable)
                    .error(R.mipmap.ic_launcher_round)

            Glide.with(imageView.context)
                .setDefaultRequestOptions(option)
                .load(url)
                .into(imageView)
        }

        fun getProgressDrawable(context: Context): CircularProgressDrawable {
            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.strokeWidth = 10f
            circularProgressDrawable.centerRadius = 50f
            circularProgressDrawable.start()
            return circularProgressDrawable
        }
    }
}