package com.marti21430.recicops.data.local.entity

import com.marti21430.recicops.data.remote.dto.PlaceDto

data class Place(
    val id: Int,
    val name: String,
    val isMaskMandatory: Boolean
)

fun Place.mapToDto(): PlaceDto = PlaceDto(
    internalID = id,
    name = name,
    isMaskMandatory = isMaskMandatory
)
