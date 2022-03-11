package de.darthkali.kmm_bike_share.interactors.recipe

import de.darthkali.kmm_bike_share.datasource.network.BicycleSharingSystemNetworkObject
import de.darthkali.kmm_bike_share.domain.util.DataState
import de.darthkali.kmm_bike_share.util.CommonFlow
import de.darthkali.kmm_bike_share.util.Logger
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchBicycleSharingSystems : KoinComponent {

    private val ingredientService: BicycleSharingSystemService by inject()
//    private val mapper = IngredientListMapper()
    private val logger = Logger("SearchBicycleSharingSystems")

    /**
     * @param query: String
     * @param page: Int
     *
     * search ingredient by name (query)
     * result depends on the page (pagination)
     * emits the result in a data object
     *
     * @return DataState
     */
    fun execute(
//        query: String,
//        page: Int
    ): CommonFlow<DataState<List<BicycleSharingSystemNetworkObject>>> = flow {
        try {
            emit(DataState.loading())

//            val ingredientList = mapper.mapTo(
//                ingredientService.searchIngredient(
//                    query = query,
//                    page = page,
//                )
//            )

            val ingredientList =
                ingredientService.searchBicycleSharingSystems()

            emit(DataState.data(data = ingredientList))
        } catch (e: Exception) {
            logger.log(e.toString())
        }
    }.asCommonFlow()
}
