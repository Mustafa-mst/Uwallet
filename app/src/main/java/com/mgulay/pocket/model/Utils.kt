package com.mgulay.pocket.model

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

open class Utils {
    fun ImageView.indir(url:String){
        var circularProgressDrawable=CircularProgressDrawable(this.context).apply {
            strokeWidth=8f
            centerRadius=40f
            start()
        }
        Glide.with(this).load(url).placeholder(circularProgressDrawable).into(this)
    }
}