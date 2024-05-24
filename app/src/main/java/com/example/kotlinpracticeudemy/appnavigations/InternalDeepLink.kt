package com.example.kotlinpracticeudemy.appnavigations

object InternalDeepLink {
    const val DOMAIN = "myapp://"

    const val HOME = "${DOMAIN}home"
    const val SECOND = "${DOMAIN}second"
    const val THIRD = "${DOMAIN}third-cart"


    fun makeCustomDeepLink(id: String): String {
        return "${DOMAIN}customDeepLink?id=${id}"
    }
}