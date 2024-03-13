package com.example.kotlinpracticeudemy

fun main() {
    var name:String="Hello   how r u  "
    var name1:String="Hello   how r u  man"
    var length:Int=name.length
    if(name.equals(name1))
    {
        println("same value")
    }
    if(name.isEmpty())
    {
        println("empty")
    }
    name=name.plus(name1)
   var lowercase= name.lowercase()
    var uppercase=name.uppercase()
    var trimmedValue=name.trim()

}