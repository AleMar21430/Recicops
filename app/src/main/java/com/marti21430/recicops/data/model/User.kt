package com.marti21430.recicops.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val L_time :String,
    var L_bolsas_plast :String,
    var L_botellas_plast :String,
    var L_botellas_vid :String,
    var L_envases_plast :String,
    var L_envases_duro :String,
    var L_libras_basura :String,
    var L_user :String
)