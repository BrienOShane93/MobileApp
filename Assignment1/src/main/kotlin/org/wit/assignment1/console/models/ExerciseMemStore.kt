package org.wit.assignment1.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class ExerciseMemStore : ExerciseStore {

    val exercises = ArrayList<ExerciseModel>()

    override fun findAll(): List<ExerciseModel> {
        return exercises
    }

    override fun findOne(id: Long) : ExerciseModel? {
        var foundExercise: ExerciseModel? = exercises.find { p -> p.id == id }
        return foundExercise
    }

    override fun create(exercise: ExerciseModel) {
        exercise.id = getId()
        exercises.add(exercise)
        logAll()
    }

    override fun update(exercise: ExerciseModel) {
        var foundExercise = findOne(exercise.id!!)
        if (foundExercise != null) {
            foundExercise.name = exercise.name
            foundExercise.set = exercise.set
        }
    }

    internal fun logAll() {
        exercises.forEach { logger.info("${it}") }
    }
}