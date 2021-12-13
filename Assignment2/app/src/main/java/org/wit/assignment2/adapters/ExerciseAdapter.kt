package org.wit.assignment2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.assignment2.databinding.CardExerciseBinding
import org.wit.assignment2.models.ExerciseModel

<<<<<<< Updated upstream
<<<<<<< Updated upstream
interface ExerciseListener {
    fun onExerciseClick(exercise: ExerciseModel)
}

class ExerciseAdapter constructor(private var exercises: List<ExerciseModel>,
                                   private val listener: ExerciseListener) :
=======
class ExerciseAdapter constructor(private var exercises: List<ExerciseModel>) :
>>>>>>> Stashed changes
=======
class ExerciseAdapter constructor(private var exercises: List<ExerciseModel>) :
>>>>>>> Stashed changes
    RecyclerView.Adapter<ExerciseAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardExerciseBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
<<<<<<< Updated upstream
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val exercise = exercises[holder.adapterPosition]
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        holder.bind(exercise, listener)
=======
        holder.bind(exercise)
>>>>>>> Stashed changes
=======
        holder.bind(exercise)
>>>>>>> Stashed changes
    }

    override fun getItemCount(): Int = exercises.size

    class MainHolder(private val binding : CardExerciseBinding) :
        RecyclerView.ViewHolder(binding.root) {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
        fun bind(exercise: ExerciseModel, listener: ExerciseListener) {
            binding.exerciseTitle.text = exercise.title
            binding.description.text = exercise.description
            binding.root.setOnClickListener { listener.onExerciseClick(exercise) }
=======
        fun bind(exercise: ExerciseModel) {
            binding.exerciseTitle.text = exercise.title
            binding.description.text = exercise.description
>>>>>>> Stashed changes
=======
        fun bind(exercise: ExerciseModel) {
            binding.exerciseTitle.text = exercise.title
            binding.description.text = exercise.description
>>>>>>> Stashed changes
        }
    }
}