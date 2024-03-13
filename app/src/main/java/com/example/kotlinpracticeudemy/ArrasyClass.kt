package com.example.kotlinpracticeudemy

fun main() {
    var simpleArr= arrayOf(1,2,3)
    val nullArray: Array<Int?> = arrayOfNulls(3)
    // Creates an Array<Int> that initializes with zeros [0, 0, 0]
    val initArray = Array<Int>(3) { 0 }
    val strArray =Array<String>(3) { "n = $it" }
    val twoDArray = Array(2) { Array<Int>(2) { 0 } }

    strArray.set(0,"sandeep")
    strArray.set(1,"pradeep")
    strArray.set(2,"kiyansh")

    nullArray.set(0,1)

    initArray.set(0,10)


}