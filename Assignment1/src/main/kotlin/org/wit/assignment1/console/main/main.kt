package org.wit.assignment1.console.main

import mu.KotlinLogging
import org.wit.assignment1.console.models.ExerciseModel

private val logger = KotlinLogging.logger {}

val exercises = ArrayList<ExerciseModel>()

fun main(args: Array<String>) {
    logger.info { "Launching Assignment 1 Console App" }
    println("Assignment 1 Kotlin App Version 2.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addExercise()
            2 -> updateExercise()
            3 -> listExercises()
            4 -> searchExercise()
            -99 -> dummyData()
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
    println(" 4. Search Placemarks")
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
    var anExercise = ExerciseModel()
    println("Add Exercise")
    println()
    print("Enter a Name : ")
    anExercise.name = readLine()!!
    print("Enter a set : ")
    anExercise.set = readLine()!!

    if (anExercise.name.isNotEmpty() && anExercise.set.isNotEmpty()) {
        exercises.add(anExercise.copy())
        logger.info("Exercise Added : [ $anExercise ]")
    }
    else
        logger.info("Exercise Not Added")
}

fun updateExercise() {
    println("Update Exercise")
    println()
    listExercises()
    var searchId = getId()
    val anExercise = search(searchId)
    var tempName : String?
    var tempSet : String?

    if(anExercise != null) {
        print("Enter a new Name for [ " + anExercise.name + " ] : ")
        tempName = readLine()!!
        print("Enter a new Set for [ " + anExercise.set + " ] : ")
        tempSet = readLine()!!

        if (!tempName.isNullOrEmpty() && !tempSet.isNullOrEmpty()) {
            anExercise.name = tempName
            anExercise.set = tempSet
            println(
                "You updated [ " + anExercise.name + " ] for name " +
                        "and [ " + anExercise.set + " ] for set")
            logger.info("Exercise Updated : [ $anExercise ]")
        }
        else
            logger.info("Exercise Not Updated")
    }
    else
        println("Exercise Not Updated...")
}

fun listExercises() {
    println("List All Exercises")
    println()
    exercises.forEach { logger.info("${it}") }
    println()
}

fun searchExercise() {

    var searchId = getId()
    val anExercise = search(searchId)

    if(anExercise != null)
        println("Exercise Details [ $anExercise ]")
    else
        println("Exercise Not Found...")
}

fun getId() : Long {
    var strId : String? // String to hold user input
    var searchId : Long // Long to hold converted id
    print("Enter id to Search/Update : ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

fun search(id: Long) : ExerciseModel? {
    var foundExercise: ExerciseModel? = exercises.find { p -> p.id == id }
    return foundExercise
}

fun dummyData() {
    exercises.add(ExerciseModel(1, "New York New York", "So Good They Named It Twice"))
    exercises.add(ExerciseModel(2, "Ring of Kerry", "Some place in the Kingdom"))
    exercises.add(ExerciseModel(3, "Waterford City", "You get great Blaas Here!!"))
}