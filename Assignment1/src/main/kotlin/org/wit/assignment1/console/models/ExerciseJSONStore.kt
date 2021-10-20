package org.wit.assignment1.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.wit.assignment1.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "exercises.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<ExerciseModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class ExerciseJSONStore : ExerciseStore {

    var exercises = mutableListOf<ExerciseModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<ExerciseModel> {
        return exercises
    }

    override fun findOne(id: Long) : ExerciseModel? {
        var foundExercise: ExerciseModel? = exercises.find { p -> p.id == id }
        return foundExercise
    }

    override fun create(exercise: ExerciseModel) {
        exercise.id = generateRandomId()
        exercises.add(exercise)
        serialize()
    }

    override fun update(exercise: ExerciseModel) {
        var foundExercise = findOne(exercise.id!!)
        if (foundExercise != null) {
            foundExercise.name = exercise.name
            foundExercise.set = exercise.set
        }
        serialize()
    }

    override fun delete(exercise: ExerciseModel) {
        exercises.remove(exercise)
        serialize()
    }

    internal fun logAll() {
        exercises.forEach { println("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(exercises, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        exercises = Gson().fromJson(jsonString, listType)
    }
}