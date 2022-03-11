package de.darthkali.kmm_bike_share.datasource.network.mapper

import de.darthkali.kmm_bike_share.datasource.BaseMapper
import de.darthkali.kmm_bike_share.datasource.network.BicycleSharingSystemNetworkObject
import de.darthkali.kmm_bike_share.domain.model.BicycleSharingSystem

class BicycleSharingSystemNetworkObjectListMapper : BaseMapper<List<BicycleSharingSystem>, List<BicycleSharingSystemNetworkObject>> {

    private val internalMapper = BicycleSharingSystemNetworkObjectMapper()

    override fun mapTo(db: List<BicycleSharingSystemNetworkObject>): List<BicycleSharingSystem> {
        val resultList = mutableListOf<BicycleSharingSystem>()

        db.forEach {
            resultList.add(internalMapper.mapTo(it))
        }
        return resultList
    }

    override fun mapBack(internal: List<BicycleSharingSystem>): List<BicycleSharingSystemNetworkObject> {
        val resultList = mutableListOf<BicycleSharingSystemNetworkObject>()

        internal.forEach {
            resultList.add(internalMapper.mapBack(it))
        }
        return resultList
    }
}
