package de.darthkali.kmm_bike_share.datasource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientSearchResponse(

    @SerialName("results")
    var results: List<IngredientDto>,

    @SerialName("offset")
    var offset: Int,

    @SerialName("number")
    var number: Int,

    @SerialName("totalResults")
    var totalResults: Int,
)
