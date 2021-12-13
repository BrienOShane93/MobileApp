package org.wit.assignment2.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExerciseModel(var id: Long = 0,
                         var title: String = "",
                         var description: String = "") : Parcelable