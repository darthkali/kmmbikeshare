package de.darthkali.kmmbikeshare.datasource.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BicycleSharingSystemNetworkObject(
    @SerialName("bssid")
    val bssid: String? = null,

    @SerialName("brand")
    val brand: String? = null,

    @SerialName("city")
    val city: String? = null,

    @SerialName("country")
    val country: String? = null,

    @SerialName("site")
    val site: String? = null,

    @SerialName("electric")
    val electric: String? = null,

    @SerialName("currently_active")
    val currentlyActive: String? = null,
)
