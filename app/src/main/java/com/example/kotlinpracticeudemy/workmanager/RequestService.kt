package com.example.kotlinpracticeudemy.workmanager

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/auth/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(AuthApi::class.java)
}