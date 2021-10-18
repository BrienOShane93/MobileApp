package org.wit.assignment1.console.models

interface ExerciseStore {
    fun findAll(): List<ExerciseModel>
    fun findOne(id: Long): ExerciseModel?
    fun create(placemark: ExerciseModel)
    fun update(placemark: ExerciseModel)
}