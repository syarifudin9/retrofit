package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apiconfig {
    const val baseURL ="https://rickandmortyapi.com/api/"

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService(): Apiservice{
        return getRetrofit().create(Apiservice::class.java)
    }
}