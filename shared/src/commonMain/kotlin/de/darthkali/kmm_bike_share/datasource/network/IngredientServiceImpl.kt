package de.darthkali.kmm_bike_share.datasource.network

import de.darthkali.kmm_bike_share.datasource.network.model.IngredientDto
import de.darthkali.kmm_bike_share.datasource.network.model.IngredientSearchResponse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class IngredientServiceImpl : IngredientService, KoinComponent {
    //    private val ktorClientFactory: de.darthkali.kmm_bike_share.network.KtorClientFactory by inject()
//    private val httpClient = ktorClientFactory.build()
    override suspend fun searchIngredient(query: String, page: Int): List<IngredientDto> {
        TODO("Not yet implemented")
    }
//    override suspend fun searchIngredient(query: String, page: Int): List<IngredientDto> {
//
//        val offset: Int = if (page > 0) ((page - 1) * PAGINATION_PAGE_SIZE) else 0
//
//        return httpClient.get<IngredientSearchResponse> {
//            url(
//                BASE_URL +
//                    "/food/ingredients/search?" +
//                    "apiKey=$API_KEY&" +
//                    "query=$query&" +
//                    "metaInformation=true&" +
//                    "offset=$offset&" +
//                    "number=$PAGINATION_PAGE_SIZE"
//            )
//        }.results
//    }

    companion object {
        const val API_KEY = "00000000000000000000000000000000" // place your own api key // TODO:  Replace with ENV
        const val BASE_URL = "https://api.spoonacular.com"
        const val PAGINATION_PAGE_SIZE = 30
        const val IMAGE_URL_SMALL = "https://spoonacular.com/cdn/ingredients_100x100"
        const val IMAGE_URL_MEDIUM = "https://spoonacular.com/cdn/ingredients_250x250"
        const val IMAGE_URL_LARGE = "https://spoonacular.com/cdn/ingredients_500x500"
        const val NO_IMAGE = "no.jpg"
    }
}
