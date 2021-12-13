package org.wit.assignment2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import org.wit.assignment2.R
import org.wit.assignment2.databinding.ActivityParolymplusBinding
import org.wit.assignment2.main.MainApp
import org.wit.assignment2.models.ExerciseModel
import timber.log.Timber.i

class ParolymplusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParolymplusBinding
    var exercise = ExerciseModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParolymplusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("Parolymplus Activity started...")
        binding.btnAdd.setOnClickListener() {
            exercise.title = binding.exerciseTitle.text.toString()
            exercise.description = binding.description.text.toString()
            if (exercise.title.isNotEmpty()) {
                app.exercises.add(exercise.copy())
                i("add Button Pressed: ${exercise}")
                for (i in app.exercises.indices) {
                    i("Exercise[$i]:${this.app.exercises[i]}")
                }
                setResult(RESULT_OK)
                finish()
            }
            else {
                Snackbar.make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_exercise, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}