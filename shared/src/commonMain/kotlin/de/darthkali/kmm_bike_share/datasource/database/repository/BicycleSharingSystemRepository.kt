package de.darthkali.kmm_bike_share.datasource.database.repository

import de.darthkali.kmm_bike_share.datasource.database.KmmBikeShareDatabaseWrapper
import de.darthkali.kmm_bike_share.util.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BicycleSharingSystemRepository : KoinComponent {

    private val weeFoodDatabase: KmmBikeShareDatabaseWrapper by inject()
    private val weeFoodDatabaseQueries = weeFoodDatabase.instance.bikeShareDbQueries
    private val logger = Logger("RecipeRepositoryImpl")

}
