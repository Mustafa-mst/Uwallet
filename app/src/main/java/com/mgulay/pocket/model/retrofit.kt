package com.mgulay.pocket.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class retrofit {
    var retrom=Retrofit.Builder().baseUrl("https://finans.truncgil.com/").addConverterFactory(GsonConverterFactory.create())
        .build().create(retroInterface::class.java)
}