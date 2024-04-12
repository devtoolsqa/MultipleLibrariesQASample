package com.example.kotlinpracticeudemy

fun main() {
    val test=MyClass.myStaticField
    println(test)
    MyClass.myStaticMethod()
}
class MyClass {
    companion object {
        val myStaticField = 10
        fun myStaticMethod() {
            // Static method implementation
        }
    }


}