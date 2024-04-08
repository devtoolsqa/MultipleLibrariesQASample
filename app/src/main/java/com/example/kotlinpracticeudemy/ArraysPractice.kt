package com.example.kotlinpracticeudemy

fun main() {

    var integerArr=Array<Int>(2) { 0 }
    var stringArr=Array<String>(2) { " " }

    var arr= arrayOf("sandeep","padala","sandy");
    for(items in arr)
    {
        println(items.toString())
    }
    arr.forEach { items-> println(items.toString()) }

    val iterarator=arr.iterator();
    while(iterarator.hasNext())
    {
        println(iterarator.next().toString())
    }

    var commonArr= arrayOf("sandeep",1,"sandy")
    for(items in commonArr)
    {
        println(items.toString())
    }
    data class User(val id: Int, val name: String, val email: String) {

        // Secondary constructor
        constructor(name: String, email: String) : this(0, name, email)
    }

    val user1=User(1,"sandeep","sandeep@gmail.com1")
    val user2=User(2,"sandeep1","sandeep@gmail.com2")
    val user3=User(3,"sandeep2","sandeep@gmail.com3")
    val user4=User(4,"sandeep3","sandeep@gmail.com4")

    var usersArr= arrayOf(user1,user2,user3,user4)

    usersArr.plus(User("gsgsg","jsjj"))

    var twoDArr= arrayOf(arrayOf(1,2,3),arrayOf(4,5,6))

    val twoDArray = Array(2) { Array<Int>(2) { 0 } }

    val threeDArray = Array(3) { Array(3) { Array<Int>(3) { 0 } } }  // Creates a 3x3x3 array filled with zeros
    println(threeDArray.contentDeepToString())

    val sampleArray = arrayOf(10, 20, 30, 40)
    //add an element to the array
    val newArrayByAddingElement = sampleArray.plus(50)
// Add a list of elements to the array
    val newArrayByAddingList = sampleArray.plus(listOf(50, 60, 70))
// Add another array of elements to the new array
    val newArrayByAddingArray = newArrayByAddingList.plus(arrayOf(80,90))
     ///Removing elements from array
    val originalArray = arrayOf(10, 20, 30, 40)

// Create a new array that filters out the number 30
    val newArrayWithout30 = originalArray.filter { it != 30 }.toTypedArray()
    println(newArrayWithout30.joinToString())

    //Removing two elements
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Remove elements 5 and 7 using filterNot()
    val filteredNumbers = numbers.filterNot { it == 5 || it == 7 }

// Print the filtered list
    println(filteredNumbers) // Output: [1, 2, 3, 4, 6, 8, 9, 10]

    ///Dropping elements from array
    val sampleArray1 = arrayOf(10, 20, 30, 40, 50, 60)

// Skip the first 3 numbers and make a new array with the rest
    val droppingFirst3Elements = sampleArray1.drop(3).toTypedArray()

// Skip the last 3 numbers and make a new array with the ones at the start
    val droppingLast3Elements = sampleArray1.dropLast(3).toTypedArray()

    println(droppingFirst3Elements.joinToString())

// Output: 40, 50, 60

    println(droppingLast3Elements.joinToString())


    val originalArray2 = intArrayOf(1, 2, 3)

// Extending the array and padding with zeros
    val paddedArray = originalArray2.copyOf(5)
    println(paddedArray.contentToString())

// Output: [1, 2, 3, 0, 0]

// Truncating the array
    val truncatedArray = originalArray2.copyOf(2)
    println(truncatedArray.contentToString())

// Output: [1, 2]

    // Before sorting
    val numbers1 = intArrayOf(3, 1, 4, 1, 5, 9)
// sorting the 'numbers' array
    numbers1.sort()

// After sorting
    println(numbers1.contentToString())

// Output: [1, 1, 3, 4, 5, 9]

    // Before sorting
    val numbers2 = intArrayOf(3, 1, 4, 1, 5, 9)
// Creating new sorted array 'sortedNumbers'
    val sortedNumbers = numbers2.sorted()

// After sorting
    println(sortedNumbers)

// Output: [1, 1, 3, 4, 5, 9]

    // Before sorting
    val numbers3 = intArrayOf(3, 1, 4, 1, 5, 9)
    numbers3.sortDescending()

// After sorting
    println(numbers3.contentToString())

// Output: [9, 5, 4, 3, 1, 1]

    val sortedNumbersDesc = numbers3.sortedDescending()

// After sorting
    println(sortedNumbersDesc)

// Output: [9, 5, 4, 3, 1, 1]

    val intArray = intArrayOf(6, 5, 4, 3, 2, 1)

// Before sorting
    println(intArray.joinToString())

// Output: 6, 5, 4, 3, 2, 1

// Sorting a range within the array
    intArray.sort(0, 3)

// After sorting
    println(intArray.joinToString())

// Output: 4, 5, 6, 3, 2, 1

    val sortedNumbers1 = arrayOf(1, 3, 5, 7, 9)

// searching the number '5' from 'sortedNumbers' array
    println(sortedNumbers1.binarySearch(5))

// Output: 2

    ///Remlving nulls
    // Array with nullable integers
    val nullableNumbers: Array<Int?> = arrayOf(1, null, 3, null, 5)

// Filter out null values
    val nonNullNumbers = nullableNumbers.filterNotNull()

    println(nonNullNumbers)

// Output: 1, 3, 5

    // Initialize a list of numbers
    val numbers5 = listOf(1, 2, 3, 4)

// Use 'map' to transform each number to its square and print the result
    println(numbers5.map { it * it })  // Each 'it' is squared (it * it)

// Output: 1, 4, 9, 16

    // Initialize two arrays with the same elements
    val arrayOne= arrayOf(1, 2, 3)
    val arrayTwo= arrayOf(1, 2, 3)

// Compare the arrays for equality
    println(arrayOne.contentEquals(arrayTwo))  // Outputs: true

// Modify an element in one of the arrays
    arrayOne[0] = 4

// Recompare the arrays after modification
    println(arrayOne.contentEquals(arrayTwo))  // Outputs: false


}

