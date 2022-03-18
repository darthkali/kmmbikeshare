package de.darthkali.kmmbikeshare.datasource.network

import io.ktor.client.HttpClient

expect class KtorClientFactory() {
    fun build(): HttpClient
}
