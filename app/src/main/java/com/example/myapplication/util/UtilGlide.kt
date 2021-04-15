package com.example.myapplication.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object UtilGlide {

    fun displayImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url).fitCenter().into(view)
    }
}