package org.wit.assignment1.console.views

import org.wit.assignment1.console.models.ExerciseJSONStore
import org.wit.assignment1.console.models.ExerciseModel

const val TEXT_PURPLE = "\u001B[35m"
const val TEXT_RED = "\u001B[31m"

const val WHITE_BOLD = "\u001b[1;37m"

const val RESET = "\u001b[0m"

class ExerciseView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println(WHITE_BOLD + "MAIN MENU" + RESET)
        println(" 1. Add Exercise")
        println(" 2. Update Exercise")
        println(" 3. List All Exercises")
        println(" 4. Search Exercises")
        println(" 5. Delete Exercise")
        println("-99. Dummy Data")
        println("-1. Exit")
        println()
        print(TEXT_PURPLE + "Enter Option : " + RESET)
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listExercises(exercises: ExerciseJSONStore) {
        println("List All Exercises")
        println()
        exercises.logAll()
        println()
    }

    fun showExercise(exercise : ExerciseModel) {
        if(exercise != null)
            println("Exercise Details [ $exercise ]")
        else
            println(TEXT_RED + "Exercise Not Found..." + RESET)
    }

    fun addExerciseData(exercise : ExerciseModel) : Boolean {

        println()
        print(TEXT_PURPLE + "Enter a Name : " + RESET)
        exercise.name = readLine()!!
        print(TEXT_PURPLE + "Enter a Set : " + RESET)
        exercise.set = readLine()!!

        return exercise.name.isNotEmpty() && exercise.set.isNotEmpty()
    }

    fun updateExerciseData(exercise : ExerciseModel) : Boolean {

        var tempName: String?
        var tempSet: String?

        if (exercise != null) {
            print(TEXT_PURPLE + "Enter a new Name for [ " + exercise.name + " ] : " + RESET)
            tempName = readLine()!!
            print(TEXT_PURPLE + "Enter a new Set for [ " + exercise.set + " ] : " + RESET)
            tempSet = readLine()!!

            if (!tempName.isNullOrEmpty() && !tempSet.isNullOrEmpty()) {
                exercise.name = tempName
                exercise.set = tempSet
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print(TEXT_PURPLE + "Enter id to Search/Update : " + RESET)
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}