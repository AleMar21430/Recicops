package com.marti21430.recicops.data.repository.place

import com.marti21430.recicops.data.local.entity.FireData
import com.marti21430.recicops.data.local.entity.mapToDto
import com.marti21430.recicops.data.remote.api.PlaceApi
import com.marti21430.recicops.data.remote.dto.mapToEntity

class PlaceRepositoryImpl(
    private val api: PlaceApi
) : PlaceRepository {
    override suspend fun createPlace(place: FireData, owner: String) {
        val dto = place.mapToDto().apply { createdBy = owner }
        api.insert(dto)
    }

    override suspend fun getPlace(id: String): FireData? {
        val placeDto = api.getById(id)
        placeDto?.apply {
            return placeDto.mapToEntity()
        }
        return null
    }

    override suspend fun getPlacesFilteredByMaskUsage(isMaskMandatory: Boolean): List<FireData>? {
        val filteredPlaces = api.getByMaskUsage(isMaskMandatory)
        filteredPlaces?.apply {
            return filteredPlaces.map { dto -> dto.mapToEntity() }
        }
        return null
    }
}