package org.wit.assignment2.main

import android.app.Application
import org.wit.assignment2.models.ExerciseModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val exercises = ArrayList<ExerciseModel>()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Parolymplus started")
    }
}