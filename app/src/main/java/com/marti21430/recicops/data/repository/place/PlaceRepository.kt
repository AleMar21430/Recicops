package com.marti21430.recicops.data.repository.place

import com.marti21430.recicops.data.local.entity.Place

interface PlaceRepository {
    suspend fun createPlace(place: Place, owner: String)
    suspend fun getPlace(id: String): Place?
    suspend fun getPlacesFilteredByMaskUsage(isMaskMandatory: Boolean): List<Place>?
}