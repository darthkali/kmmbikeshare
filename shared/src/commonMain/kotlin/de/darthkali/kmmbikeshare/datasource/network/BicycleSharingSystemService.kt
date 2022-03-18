package de.darthkali.kmmbikeshare.datasource.network

import io.ktor.client.request.get
import io.ktor.client.request.url
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BicycleSharingSystemService : KoinComponent {
    private val ktorClientFactory: KtorClientFactory by inject()
    private val httpClient = ktorClientFactory.build()

    suspend fun searchBicycleSharingSystems(
        country: String
    ): List<BicycleSharingSystemNetworkObject> {
        return httpClient.get {
            url(
                BASE_URL +
                    "/categories/base/fields/brand,city,country,electric,site,currently_active/locations/" +
                    country
            )
        }
    }

    companion object {
        const val BASE_URL = "https://bikeshare-research.org/api/v1"
    }
}
