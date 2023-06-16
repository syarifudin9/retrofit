package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface Apiservice {
    @GET ("character")
    fun getRick (): Call<ResponseRick>
}