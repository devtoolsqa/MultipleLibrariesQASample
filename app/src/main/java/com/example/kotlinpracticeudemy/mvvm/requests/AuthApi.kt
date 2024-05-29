package com.example.kotlinpracticeudemy.mvvm.requests


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("login")
    fun loginMember(@Body loginRequest: LoginRequest): Call<Profile>
}