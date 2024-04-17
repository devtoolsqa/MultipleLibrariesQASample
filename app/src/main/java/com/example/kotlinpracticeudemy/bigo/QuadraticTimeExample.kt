package com.example.kotlinpracticeudemy.bigo
//O(n²) → Quadratic Time
fun main() {

}

fun bubbleSort(array: IntArray): IntArray {
    val n = array.size

    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (array[j] > array[j + 1]) {
                // swap the elements
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }

    return array
}

//if we see one for loop inside another for loop we can consider as  O(n²)