package com.example.kotlinpracticeudemy.workmanager

import android.content.Context

import android.util.Log

import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.kotlinpracticeudemy.workmanager.RequestService.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkWorker (context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        try {
            // Create your data model object
            val data = LoginRequest(username = "kminchelle", password = "0lelplR")

            // Make API call using Retrofit
            val response = apiService.loginMember(data)


            response.enqueue(object : Callback<Profile> {
                override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                    if (response.isSuccessful) {
                        val email= response.body()?.email
                        Log.e("User Email", "$email")
                    } else {
                        setIsError("Error occurred during API call")
                    }
                }

                override fun onFailure(call: Call<Profile>, t: Throwable) {
                    setIsError(t.toString())
                }
            })

            return Result.success()
        } catch (e: Exception) {
            setIsError(e.toString())
            return Result.failure()
        }
    }

    private fun setIsError(error: String) {
        // Handle error here
        Log.e("MyWorker", "Error: $error")
    }
}