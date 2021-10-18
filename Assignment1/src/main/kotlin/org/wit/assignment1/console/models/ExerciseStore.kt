package org.wit.assignment1.console.models

interface ExerciseStore {
    fun findAll(): List<ExerciseModel>
    fun findOne(id: Long): ExerciseModel?
    fun create(exercise: ExerciseModel)
    fun update(exercise: ExerciseModel)
    fun delete(exercise: ExerciseModel)
}