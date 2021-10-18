package org.wit.assignment1.console.views

import org.wit.assignment1.console.main.exercises
import org.wit.assignment1.console.models.ExerciseMemStore
import org.wit.assignment1.console.models.ExerciseModel

class ExerciseView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Exercise")
        println(" 2. Update Exercise")
        println(" 3. List All Exercises")
        println(" 4. Search Exercises")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listExercises(exercises : ExerciseMemStore) {
        println("List All Exercises")
        println()
        exercises.logAll()
        println()
    }

    fun showExercise(exercise : ExerciseModel) {
        if(exercise != null)
            println("Exercise Details [ $exercise ]")
        else
            println("Exercise Not Found...")
    }

    fun addExerciseData(exercise : ExerciseModel) : Boolean {

        println()
        print("Enter a Name : ")
        exercise.name = readLine()!!
        print("Enter a Set : ")
        exercise.set = readLine()!!

        return exercise.name.isNotEmpty() && exercise.set.isNotEmpty()
    }

    fun updateExerciseData(exercise : ExerciseModel) : Boolean {

        var tempName: String?
        var tempSet: String?

        if (exercise != null) {
            print("Enter a new Name for [ " + exercise.name + " ] : ")
            tempName = readLine()!!
            print("Enter a new Set for [ " + exercise.set + " ] : ")
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
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}