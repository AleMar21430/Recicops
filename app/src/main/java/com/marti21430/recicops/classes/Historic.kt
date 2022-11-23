package com.marti21430.recicops.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity
data class Historic(
    @PrimaryKey(autoGenerate = true)
    val id : String,
    val date: String,
    val duroport:String,
    val plasticBags:String,
    val cristal:String,
    val trash_weight:String,
    val plastic_bottles: String,
    val plastic_envase: String
)