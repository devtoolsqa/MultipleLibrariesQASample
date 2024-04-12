package com.example.kotlinpracticeudemy

fun main() {
    var number:Int=1
    var day:String=""

    when(number)
    {
        1->day="sunday"
        2->day="monday"
        3->day="tuesday"
        4->day="wednesday"
        5->day="thursday"
    }

    for(i in 1..10)
    {
        println(day+"$i")

    }

    var list= listOf("sandeep","pradeep","John")
    for(i in list)
    {
        println(i)
    }

    list.forEach{ println(it) }

    while(number<=10)
    {
        println(day+"$number")
        number++



    }

    do {

    }
        while (number<10)
    {

    }


    fun addNumbers(a:Int,b:Int):Int
    {
        return a+b
    }
}