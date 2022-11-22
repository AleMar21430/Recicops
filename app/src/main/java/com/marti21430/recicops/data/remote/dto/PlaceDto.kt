package com.marti21430.recicops.data.remote.dto

import com.marti21430.recicops.data.local.entity.Place

data class PlaceDto(
    val internalID: Int = 0,
    val name: String = "",
    val isMaskMandatory: Boolean = false,
    var createdBy: String = "" // guarda el ID del usuario loggeado
)

fun PlaceDto.mapToEntity(): Place = Place(
    id = internalID,
    name = name,
    isMaskMandatory = isMaskMandatory
)