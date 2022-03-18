package de.darthkali.kmmbikeshare.interactors

import de.darthkali.kmmbikeshare.datasource.network.BicycleSharingSystemService
import de.darthkali.kmmbikeshare.datasource.network.mapper.BicycleSharingSystemNetworkObjectListMapper
import de.darthkali.kmmbikeshare.domain.model.BicycleSharingSystem
import de.darthkali.kmmbikeshare.domain.util.DataState
import de.darthkali.kmmbikeshare.util.CommonFlow
import de.darthkali.kmmbikeshare.util.Logger
import de.darthkali.kmmbikeshare.util.asCommonFlow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchBicycleSharingSystems : KoinComponent {

    private val bicycleSharingSystemService: BicycleSharingSystemService by inject()
    private val mapper = BicycleSharingSystemNetworkObjectListMapper()
    private val logger = Logger("SearchBicycleSharingSystems")

    /**
     * @param country: String
     *
     * search BicycleSharingSystem List by country
     * emits the result in a data object
     *
     * @return DataState
     */
    fun execute(
        country: String,
    ): CommonFlow<DataState<List<BicycleSharingSystem>>> = flow {
        try {

            emit(DataState.loading())

            val bicycleSharingSystemList = mapper.mapTo(
                bicycleSharingSystemService.searchBicycleSharingSystems(
                    country = country,
                )
            )
            emit(DataState.data(data = bicycleSharingSystemList))
        } catch (e: Exception) {
            logger.log(e.toString())
        }
    }.asCommonFlow()
}
