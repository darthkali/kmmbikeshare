package de.darthkali.kmm_bike_share.datasource.network

import de.darthkali.kmm_bike_share.datasource.network.model.IngredientDto

interface IngredientService {
    suspend fun searchIngredient(
        query: String,
        page: Int,
    ): List<IngredientDto>
}
