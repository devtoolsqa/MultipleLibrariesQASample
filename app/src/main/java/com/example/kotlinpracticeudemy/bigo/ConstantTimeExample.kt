package com.example.kotlinpracticeudemy.bigo
//O(1) → Constant Time
fun main() {
var arr= arrayOf(1,2,3,4,5)
    var resultValue= getIndex(2)
}


fun  getIndex(index:Int,vararg numbers: Int):Int{
return numbers[index]
}
fun  getIndexNew(index:Int,numbers: Array<Int>):Int{
    return numbers[index]
}


//Above is perfect example of O(1)