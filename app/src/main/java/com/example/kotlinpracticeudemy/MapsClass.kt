package com.example.kotlinpracticeudemy

fun main() {
    //Linked hashmap maintain order normal hashmap no order
    //mapof function retunrs immutable map we can modify add values
    //mutablemapof function returns mutable map we can manipulate this

    val hashMap=LinkedHashMap<String,Int>();
    hashMap.put("key1",1)

    val hashMap2= mapOf("key1" to 1)

    val keyValue="key1" to 1

    val hashMap3= mapOf(keyValue)

    ///conditional map creation:

    val keyValue1="key1" to 1

    val keyValue2="key1" to 4

    val keyValue3="key1" to 8

    val hashmap3= listOfNotNull(keyValue1,keyValue2.takeIf { it.second==4 },keyValue3.takeIf { it.second==8 })


     ////Hashmap using functional APIS
     data class IceCreamShipment(val flavor: String, val quantity: Int)

    val shipments = listOf(
        IceCreamShipment("Chocolate", 3),
        IceCreamShipment("Strawberry", 7),
        IceCreamShipment("Vanilla", 5),
        IceCreamShipment("Chocolate", 5),
        IceCreamShipment("Vanilla", 1),
        IceCreamShipment("Rocky Road", 10),
    )



    val iceCreamInventory = shipments
        .groupBy({ it.flavor }, { it.quantity })
        .mapValues { it.value.sum() }


//Filtering

    val inventory = mutableMapOf(
        "Vanilla" to 24,
        "Chocolate" to 14,
        "Strawberry" to 9,
    )
///map with 10 above count
    val lotsLeft = inventory.filterValues { qty -> qty > 10 }

    val sales = mapOf("Vanilla" to 7, "Chocolate" to 4, "Strawberry" to 5)

    val shipmentsnew = mapOf("Chocolate" to 3, "Strawberry" to 7, "Rocky Road" to 5)

    with(inventory) {
        sales.forEach { merge(it.key, it.value, Int::minus) }
        shipmentsnew.forEach { merge(it.key, it.value, Int::plus) }
    }

    // Iterate through the map using a for loop
    for ((key, value) in inventory) {
        println("Key: $key, Value: $value")
    }

// Iterate through the keys of the map
    for (key in inventory.keys) {
        println("Key: $key")
    }

// Iterate through the values of the map
    for (value in inventory.values) {
        println("Value: $value")
    }











}


