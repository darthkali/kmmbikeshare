package de.darthkali.kmm_bike_share.datasource.network

import de.darthkali.kmm_bike_share.util.Logger
import io.ktor.client.request.get
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import io.ktor.client.request.url


class BicycleSharingSystemService : KoinComponent {
    private val ktorClientFactory: KtorClientFactory by inject()
    private val httpClient = ktorClientFactory.build()

    suspend fun searchBicycleSharingSystems(
        country: String
    ): List<BicycleSharingSystemNetworkObject> {

        println("Start Network connection")
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
