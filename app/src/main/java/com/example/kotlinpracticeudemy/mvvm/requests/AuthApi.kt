package com.example.kotlinpracticeudemy.mvvm.requests


import com.example.kotlinpracticeudemy.mvvm.models.Photo
import com.example.kotlinpracticeudemy.mvvm.models.Photos
import com.example.kotlinpracticeudemy.workmanager.LoginRequest
import com.example.kotlinpracticeudemy.workmanager.Profile
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    fun getPhotos(@Query("sol") sol: Int,
                  @Query("page") page: Int,
                  @Query("api_key") apiKey: String): Call<Photos>
}