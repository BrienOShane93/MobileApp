package org.wit.assignment2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.assignment2.databinding.CardExerciseBinding
import org.wit.assignment2.models.ExerciseModel

class ExerciseAdapter constructor(private var exercises: List<ExerciseModel>) :
    RecyclerView.Adapter<ExerciseAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardExerciseBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val exercise = exercises[holder.adapterPosition]
        holder.bind(exercise)
    }

    override fun getItemCount(): Int = exercises.size

    class MainHolder(private val binding : CardExerciseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: ExerciseModel) {
            binding.exerciseTitle.text = exercise.title
            binding.description.text = exercise.description
        }
    }
}