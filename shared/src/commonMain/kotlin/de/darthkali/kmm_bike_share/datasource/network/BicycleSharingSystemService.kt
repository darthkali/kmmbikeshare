package de.darthkali.kmm_bike_share.datasource.network

import io.ktor.client.request.get
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import io.ktor.client.request.url


class BicycleSharingSystemService : KoinComponent {
    private val ktorClientFactory: KtorClientFactory by inject()
    private val httpClient = ktorClientFactory.build()

    suspend fun searchBicycleSharingSystems(
//        query: String
    ): List<BicycleSharingSystemNetworkObject> {
        return httpClient.get {
            url(
                BASE_URL +
                        "/categories/base/fields/brand,city,country,electric,site,currently_active/locations/Germany/"
            )
        }
    }

    companion object {
        const val BASE_URL = "https://bikeshare-research.org/api/v1"
    }
}
