package com.marti21430.recicops.data.repository.place

import com.marti21430.recicops.data.local.entity.FireData

interface PlaceRepository {
    suspend fun createPlace(place: FireData, owner: String)
    suspend fun getPlace(id: String): FireData?
    suspend fun getPlacesFilteredByMaskUsage(isMaskMandatory: Boolean): List<FireData>?
}