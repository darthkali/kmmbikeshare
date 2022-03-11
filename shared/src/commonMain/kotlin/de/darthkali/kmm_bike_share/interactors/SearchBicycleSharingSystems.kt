package de.darthkali.kmm_bike_share.interactors

import de.darthkali.kmm_bike_share.datasource.network.BicycleSharingSystemService
import de.darthkali.kmm_bike_share.datasource.network.mapper.BicycleSharingSystemNetworkObjectListMapper
import de.darthkali.kmm_bike_share.domain.model.BicycleSharingSystem
import de.darthkali.kmm_bike_share.domain.util.DataState
import de.darthkali.kmm_bike_share.util.CommonFlow
import de.darthkali.kmm_bike_share.util.Logger
import de.darthkali.kmm_bike_share.util.asCommonFlow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchBicycleSharingSystems : KoinComponent {

    private val bicycleSharingSystemService: BicycleSharingSystemService by inject()
    private val mapper = BicycleSharingSystemNetworkObjectListMapper()
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
        country: String,
    ): CommonFlow<DataState<List<BicycleSharingSystem>>> = flow {
        try {
            emit(DataState.loading())

            val ingredientList = mapper.mapTo(
                bicycleSharingSystemService.searchBicycleSharingSystems(
                    country = country,
                )
            )
            emit(DataState.data(data = ingredientList))
        } catch (e: Exception) {
            logger.log(e.toString())
        }
    }.asCommonFlow()
}
