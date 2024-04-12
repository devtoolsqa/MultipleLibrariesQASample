package com.example.kotlinpracticeudemy

fun main() {


    val message = "Hello"
    val modifiedMessage = message.addExclamation() // Extension function usage

    println(modifiedMessage) // Output: Hello!
}
fun String.addExclamation(): String {
    return "$this!"
}