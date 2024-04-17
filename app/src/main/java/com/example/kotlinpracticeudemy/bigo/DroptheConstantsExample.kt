package com.example.kotlinpracticeudemy.bigo

fun main() {
    var namesList= listOf("sandeep","pradeep","jsjs","kkks","sandeep","pradeep","jsjs","kkks","sandeep","pradeep","jsjs","kkks")
    for (name in namesList) {

            println(name)

    }

    for (name in namesList) {

        println(name)

    }

}

/*
run time is n+n=2n 2 is constant so we can drop drop 2 and consider as o(n)
 */