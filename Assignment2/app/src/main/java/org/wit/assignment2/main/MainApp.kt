package org.wit.assignment2.main

import android.app.Application
import org.wit.assignment2.models.ExerciseJSONStore
import org.wit.assignment2.models.ExerciseStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var exercises: ExerciseStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        exercises = ExerciseJSONStore(applicationContext)
        i("Exercise started")
    }
}