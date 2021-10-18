package org.wit.assignment1.console.controllers

import mu.KotlinLogging
import org.wit.assignment1.console.models.ExerciseJSONStore
import org.wit.assignment1.console.models.ExerciseModel
import org.wit.assignment1.console.views.ExerciseView
import java.nio.file.Files.delete

class ExerciseController {

    val exercises = ExerciseJSONStore()
    val exerciseView = ExerciseView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Assignment 1 Console App" }
        println("Assignment 1 Kotlin App Version 4.0")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                5 -> delete()
                -99 -> dummyData()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Assignment 1 Console App" }
    }

    fun menu() :Int { return exerciseView.menu() }

    fun add(){
        var anExercise = ExerciseModel()

        if (exerciseView.addExerciseData(anExercise))
            exercises.create(anExercise)
        else
            logger.info("Exercise Not Added")
    }

    fun list() {
        exerciseView.listExercises(exercises)
    }

    fun update() {

        exerciseView.listExercises(exercises)
        var searchId = exerciseView.getId()
        val anExercise = search(searchId)

        if(anExercise != null) {
            if(exerciseView.updateExerciseData(anExercise)) {
                exercises.update(anExercise)
                exerciseView.showExercise(anExercise)
                logger.info("Exercise Updated : [ $anExercise ]")
            }
            else
                logger.info("Exercise Not Updated")
        }
        else
            println("Exercise Not Updated...")
    }

    fun delete() {
        exerciseView.listExercises(exercises)
        var searchId = exerciseView.getId()
        val anExercise = search(searchId)

        if(anExercise != null) {
            exercises.delete(anExercise)
            println("Exercise Deleted...")
            exerciseView.listExercises(exercises)
        }
        else
            println("Exercise Not Deleted...")
    }

    fun search() {
        val anExercise = search(exerciseView.getId())!!
        exerciseView.showExercise(anExercise)
    }


    fun search(id: Long) : ExerciseModel? {
        var foundExercise = exercises.findOne(id)
        return foundExercise
    }

    fun dummyData() {
        exercises.create(ExerciseModel(name = "New York New York", set = "So Good They Named It Twice"))
        exercises.create(ExerciseModel(name = "Ring of Kerry", set = "Some place in the Kingdom"))
        exercises.create(ExerciseModel(name = "Waterford City", set = "You get great Blaas Here!!"))
    }
}