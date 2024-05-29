package com.example.kotlinpracticeudemy.mvvm.models

data class Rover (
    val id:Int,
    val name:String,
    val landingDate:String,
    val launchDate:String,
    val status:String,
    val maxSol:Int,
    val maxDate:String,
    val totalPhotos:Int,
    val cameras:List<Rover>)
