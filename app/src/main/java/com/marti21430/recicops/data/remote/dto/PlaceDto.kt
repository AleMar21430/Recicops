package com.marti21430.recicops.data.remote.dto

import com.marti21430.recicops.data.local.entity.FireData

data class PlaceDto(
    val internalID: Int = 0,
    val user: String = "",
    val time: String = "31/12/2000 00:00",
    val bolsas_plast: Int,
    val botellas_plast: Int,
    val botellas_vid: Int,
    val envases_plast: Int,
    val envases_duro: Int,
    val libras_basura: Float,
    var createdBy: String = "" // guarda el ID del usuario loggeado
)

fun PlaceDto.mapToEntity(): FireData = FireData(
    id = internalID,
    user = user,
    time = time,
    bolsas_plast = bolsas_plast,
    botellas_plast = botellas_plast,
    botellas_vid =botellas_vid,
    envases_plast = envases_plast,
    envases_duro = envases_duro,
    libras_basura = libras_basura
)