package org.wit.assignment2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import org.wit.assignment2.databinding.ActivityParolymplusBinding
import org.wit.assignment2.models.ExerciseModel
import timber.log.Timber
import timber.log.Timber.i

class ParolymplusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParolymplusBinding
    var exercise = ExerciseModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParolymplusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("Parolymplus Activity started...")

        binding.btnAdd.setOnClickListener() {
            exercise.title = binding.exerciseTitle.text.toString()
            if (exercise.title.isNotEmpty()) {
                i("add Button Pressed: $exercise.title")
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}