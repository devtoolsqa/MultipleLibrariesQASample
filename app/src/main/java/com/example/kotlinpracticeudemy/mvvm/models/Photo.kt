package com.example.kotlinpracticeudemy.mvvm.models

data class Photo(
    val id: Int,
    val sol: Int,
    val camera: Camera,
    val imgSrc:String,
    val earthDate:String,
    val rover: Rover
)
