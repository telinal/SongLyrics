package com.example.songlyrics.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageURL")
fun AdapterUtils(image: ImageView, url: String) {

    Glide.with(image).load(url).into(image)
}