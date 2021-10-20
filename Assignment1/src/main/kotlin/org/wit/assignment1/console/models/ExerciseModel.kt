package org.wit.assignment1.console.models

data class ExerciseModel(var id: Long = 0,
                         //Tried to use - var name: Strokes. Did not work
                         var name: String = "",
                         //Tried to use - var set: Lengths. Did not work
                         var set: String = ""
                        )