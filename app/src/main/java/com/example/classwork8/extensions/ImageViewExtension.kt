package com.example.classwork8.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(imgUrl: Any) {
    Glide.with(this).load(imgUrl).into(this)
}