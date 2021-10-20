package org.wit.assignment1.console.controllers

import mu.KotlinLogging
import org.wit.assignment1.console.models.ExerciseJSONStore
import org.wit.assignment1.console.models.ExerciseModel
import org.wit.assignment1.console.views.ExerciseView

const val TEXT_PURPLE = "\u001B[35m"
const val TEXT_RED = "\u001B[31m"
const val TEXT_GREEN = "\u001B[32m"

const val RESET = "\u001b[0m"

class ExerciseController {

    val exercises = ExerciseJSONStore()
    val exerciseView = ExerciseView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info {TEXT_PURPLE + "Launching Assignment 1 Console App" + RESET}
        println(TEXT_GREEN + "Assignment 1 Kotlin App Version 4.1" + RESET)
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
                -1 -> println(TEXT_RED + "Exiting App" + RESET)
                else -> println(TEXT_RED + "Invalid Option" + RESET)
            }
            println()
        } while (input != -1)
        logger.info {TEXT_RED + "Shutting Down Assignment 1 Console App" + RESET}
    }

    fun menu() :Int { return exerciseView.menu() }

    fun add(){
        var anExercise = ExerciseModel()

        if (exerciseView.addExerciseData(anExercise))
            exercises.create(anExercise)
        else
            logger.info(TEXT_RED + "Exercise Not Added" + RESET)
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
                logger.info(TEXT_GREEN + "Exercise Updated :" + RESET + "[ $anExercise ]")
            }
            else
                logger.info(TEXT_RED + "Exercise Not Updated" + RESET)
        }
        else
            println(TEXT_RED + "Exercise Not Updated..." + RESET)
    }

    fun delete() {
        exerciseView.listExercises(exercises)
        var searchId = exerciseView.getId()
        val anExercise = search(searchId)

        if(anExercise != null) {
            exercises.delete(anExercise)
            println(TEXT_GREEN + "Exercise Deleted..." + RESET)
            exerciseView.listExercises(exercises)
        }
        else
            println(TEXT_RED + "Exercise Not Deleted..." + RESET)
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
        exercises.create(ExerciseModel(name = "Freestyle", set = "100m"))
        exercises.create(ExerciseModel(name = "Breast Stroke", set = "50m"))
        exercises.create(ExerciseModel(name = "Individual Medley", set = "4x100m"))
    }
}