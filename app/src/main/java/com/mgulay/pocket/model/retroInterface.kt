package com.mgulay.pocket.model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface retroInterface {
    @GET("today.json")
     suspend fun getValues():Response<DataClass>
}