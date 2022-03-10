package de.darthkali.kmm_bike_share.datasource.network

import io.ktor.client.HttpClient

expect class KtorClientFactory() {
    fun build(): HttpClient
}
