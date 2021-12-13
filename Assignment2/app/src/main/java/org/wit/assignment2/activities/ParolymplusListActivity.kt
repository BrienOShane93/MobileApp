package org.wit.assignment2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.assignment2.R
import org.wit.assignment2.adapters.ExerciseAdapter
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import org.wit.assignment2.adapters.ExerciseListener
import org.wit.assignment2.databinding.ActivityParolymplusListBinding
import org.wit.assignment2.main.MainApp
import org.wit.assignment2.models.ExerciseModel

class ParolymplusListActivity : AppCompatActivity(), ExerciseListener {
=======
=======
>>>>>>> Stashed changes
import org.wit.assignment2.databinding.ActivityParolymplusListBinding
import org.wit.assignment2.main.MainApp

class ParolymplusListActivity : AppCompatActivity() {
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    lateinit var app: MainApp
    private lateinit var binding: ActivityParolymplusListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParolymplusListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        binding.recyclerView.adapter = ExerciseAdapter(app.exercises.findAll(),this)
=======
        binding.recyclerView.adapter = ExerciseAdapter(app.exercises)
>>>>>>> Stashed changes
=======
        binding.recyclerView.adapter = ExerciseAdapter(app.exercises)
>>>>>>> Stashed changes
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, ParolymplusActivity::class.java)
                startActivityForResult(launcherIntent,0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream

    override fun onExerciseClick(exercise: ExerciseModel) {
        val launcherIntent = Intent(this, ParolymplusActivity::class.java)
        launcherIntent.putExtra("exercise_edit", exercise)
        startActivityForResult(launcherIntent,0)
    }
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}