package com.example.kotlinpracticeudemy

fun main() {

    //Simple Array
    val sampleArray = arrayOf(10, 20, 30, 40)
    println(sampleArray.joinToString())

    // create an array of null, null
    val sampleNullArray = arrayOfNulls<Int?>(2)
    println(sampleNullArray.joinToString())

// creates a simple array of 1s, where 3 is the size of the array
    val simpleArray = Array<Int>(3) { 1 }
    println(simpleArray.joinToString())

    // creates the modified array of elements, where i is the index,
// so everytime the i gets multiplied by 2, and size is 3
    val advancedArray = Array<Int>(3) { i -> i * 2 }
    println(advancedArray.joinToString())


    val array = arrayOf(1, 2, 3)
    for (item in array) {
        println(item)
    }

   // Using the forEach operator:

    val array1 = arrayOf(1, 2, 3)
    array1.forEach { item ->
        println(item)
    }
    val array2 = arrayOf(1, 2, 3)
    val iterator = array2.iterator()

    while (iterator.hasNext()) {
        val item = iterator.next()
        println(item)
    }

}