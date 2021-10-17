package org.wit.assignment1.console.main

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    logger.info { "Launching Assignment 1 Console App" }
    println("Assignment 1 Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addExercise()
            2 -> updateExercise()
            3 -> listExercises()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Assignment 1 Console App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("MAIN MENU")
    println(" 1. Add Exercise")
    println(" 2. Update Exercise")
    println(" 3. List All Exercises")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addExercise(){
    println("You Chose Add Exercise")
}

fun updateExercise() {
    println("You Chose Update Exercise")
}

fun listExercises() {
    println("You Chose List All Exercises")
}