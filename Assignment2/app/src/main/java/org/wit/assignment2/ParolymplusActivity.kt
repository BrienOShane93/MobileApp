package org.wit.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber
import timber.log.Timber.i

class ParolymplusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parolymplus)

        Timber.plant(Timber.DebugTree())

        i("Parolymplus Activity started..")
    }
}