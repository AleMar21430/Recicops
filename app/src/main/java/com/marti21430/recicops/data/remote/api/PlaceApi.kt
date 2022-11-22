package com.marti21430.recicops.data.remote.api

import com.marti21430.recicops.data.remote.dto.PlaceDto

interface PlaceApi {
    suspend fun insert(place: PlaceDto)
    suspend fun getById(id: String): PlaceDto?
    suspend fun getByMaskUsage(isMaskMandatory: Boolean): List<PlaceDto>?
}