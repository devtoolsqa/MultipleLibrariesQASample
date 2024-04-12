package com.example.kotlinpracticeudemy

/*
A sealed class in Kotlin is a class that can have a limited set of subclasses defined within it. It allows you to restrict the inheritance hierarchy and define a closed set of possible subclasses.

Sealed classes are useful when you want to represent a restricted type hierarchy, where all the possible subclasses are known in advance and should be handled exhaustively in when expressions.*/


fun main() {
    processResult(Result.Error("Error message"))
}
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

fun processResult(result: Result) {
    when (result) {
        is Result.Success -> {
            println("Success: ${result.data}")
        }
        is Result.Error -> {
            println("Error: ${result.message}")
        }
        Result.Loading -> {
            println("Loading...")
        }
    }
}