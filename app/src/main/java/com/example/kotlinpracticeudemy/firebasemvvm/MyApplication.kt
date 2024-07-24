package com.example.kotlinpracticeudemy.firebasemvvm

import android.app.Application

import androidx.work.Configuration
import androidx.work.WorkManager
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {
    val myConfig = Configuration.Builder().build()
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)
        WorkManager.initialize(this, myConfig)
    }
}