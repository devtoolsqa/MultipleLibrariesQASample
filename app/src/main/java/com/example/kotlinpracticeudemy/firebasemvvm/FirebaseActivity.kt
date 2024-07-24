package com.example.kotlinpracticeudemy.firebasemvvm

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController

import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinpracticeudemy.R


import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirebaseActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firebase_activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (navController.currentDestination?.id == R.id.loginFragment){
            moveTaskToBack(true)
        }else{
            super.onBackPressed()
        }
    }
}