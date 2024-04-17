package com.example.kotlinpracticeudemy.bigo

fun main() {
    var namesList= listOf("sandeep","pradeep","jsjs","kkks","sandeep","pradeep","jsjs","kkks","sandeep","pradeep","jsjs","kkks")
    for (name in namesList) {

        println(name)

    }

    for (name in namesList) {

        println(name)

    }

    var name=namesList.toString()
}
/*
here n+n+o(1)=2n+O(1) we can drop O(1) and consider run time as O(n
 */