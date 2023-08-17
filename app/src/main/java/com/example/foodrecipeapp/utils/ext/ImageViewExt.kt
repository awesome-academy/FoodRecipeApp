package com.example.foodrecipeapp.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.foodrecipeapp.R

fun ImageView.loadImageCircleWithUrl(url: String) {
    Glide.with(this)
        .load(url)
        .placeholder(R.mipmap.ic_launcher)
        .circleCrop()
        .into(this)
}

fun ImageView.loadImageWithUrl(url: String) {
    Glide.with(this)
        .load(url)
        .placeholder(R.mipmap.ic_launcher)
        .into(this)
}
