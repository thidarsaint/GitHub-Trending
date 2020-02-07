package com.tds.githubtrending.model.api

import com.tds.githubtrending.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
//    val instance = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()

//    val apiService = instance.create(ApiService::class.java)

    val instance = Retrofit.Builder().run {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        build()
    }.create(ApiService::class.java)



}