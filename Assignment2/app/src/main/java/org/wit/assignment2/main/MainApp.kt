package org.wit.assignment2.main

import android.app.Application
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import org.wit.assignment2.models.ExerciseMemStore
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
import org.wit.assignment2.models.ExerciseModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    val exercises = ExerciseMemStore()
=======
    val exercises = ArrayList<ExerciseModel>()
>>>>>>> Stashed changes
=======
    val exercises = ArrayList<ExerciseModel>()
>>>>>>> Stashed changes

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Parolymplus started")
    }
}