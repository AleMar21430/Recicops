package com.marti21430.recicops.data.local.entity

import com.marti21430.recicops.data.remote.dto.PlaceDto

data class FireData(
    val id: Int,
    val user: String,
    val time: String,
    val bolsas_plast: Int,
    val botellas_plast: Int,
    val botellas_vid: Int,
    val envases_plast: Int,
    val envases_duro: Int,
    val libras_basura: Float
)

fun FireData.mapToDto(): PlaceDto = PlaceDto(
    internalID = id,
    user = user,
    time = time,
    bolsas_plast,
    botellas_plast,
    botellas_vid,
    envases_plast,
    envases_duro,
    libras_basura
)
