package com.example.kotlinpracticeudemy.bigo

fun main() {
    var arr1 = arrayOf(1, 2, 3, 4, 5)
    var arr2 = arrayOf(6, 7, 8, 9, 10)

    for(i in arr1)
    {
        println(arr1[i])
    }
    for(j in arr2)
    {
        println(arr1[j])
    }

    //here run time is O(arr1.size+arr2.size)

    for(i in arr1)
    {
        for(j in arr2)
        {
            println(arr1[i])
            println(arr1[j])
        }
    }
    //here run time is O(arr1.size*arr2.size)
}
