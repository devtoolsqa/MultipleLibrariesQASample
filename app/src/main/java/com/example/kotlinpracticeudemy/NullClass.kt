package com.example.kotlinpracticeudemy

fun main() {
          fun printReview(name: String, stars: Int?) =
                    println("$name gave it $stars stars!")

          val saraStars: Int? =5

          printReview("Sara", saraStars)

          val payment: Payment? = null

          val coffee = orderCoffee(payment ?: getPaymentFromFriend())
}

fun getPaymentFromFriend(): Payment {

          return Payment()
}

fun orderCoffee(payment: Payment): Any {
return Coffee()
}

class Coffee {

}

class Payment {

}
