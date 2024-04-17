package com.example.kotlinpracticeudemy.bigo
//O(log n) → Logarithmic Time
fun main() {
    var smallNumber=1000;
    var bigNumber=1000000000;



}

fun countDigits(number:Int):Int{
    var count=0
    var i=1

    while(i<number){

        i *= 2;
        count++

    }
       return count

}

//In above example loop will run less than the input value we can consider it as O(logn)