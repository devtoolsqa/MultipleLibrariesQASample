package com.example.kotlinpracticeudemy

fun main() {
    val addResult = calculate(5, 3) { a, b -> a + b } // Higher-order function usage

    println("Addition Result"+addResult) // Output: 8

    val MulResult = calculate(5, 3) { a, b -> a * b } // Higher-order function usage

    println("Addition Result"+MulResult) // Output: 15
}
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}