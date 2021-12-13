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
<<<<<<< Updated upstream
=======
import timber.log.Timber.i
>>>>>>> Stashed changes

class ParolymplusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParolymplusBinding
    var exercise = ExerciseModel()
<<<<<<< Updated upstream
    lateinit var app: MainApp
=======
    lateinit var app : MainApp
>>>>>>> Stashed changes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var edit = false
        binding = ActivityParolymplusBinding.inflate(layoutInflater)
        setContentView(binding.root)
<<<<<<< Updated upstream
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)
        app = application as MainApp

        if (intent.hasExtra("exercise_edit")) {
            edit = true
            exercise = intent.extras?.getParcelable("exercise_edit")!!
            binding.exerciseTitle.setText(exercise.title)
            binding.description.setText(exercise.description)
            binding.btnAdd.setText(R.string.save_exercise)
        }
=======
>>>>>>> Stashed changes

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("Parolymplus Activity started...")
        binding.btnAdd.setOnClickListener() {
            exercise.title = binding.exerciseTitle.text.toString()
            exercise.description = binding.description.text.toString()
<<<<<<< Updated upstream
            if (exercise.title.isEmpty()) {
                Snackbar.make(it,R.string.enter_exercise_title, Snackbar.LENGTH_LONG)
=======
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
>>>>>>> Stashed changes
                    .show()
            } else {
                if (edit) {
                    app.exercises.update(exercise.copy())
                } else {
                    app.exercises.create(exercise.copy())
                }
            }
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_exercise, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> { finish() }
        }
        return super.onOptionsItemSelected(item)
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