package de.darthkali.kmmbikeshare.datasource.database.mapper

import de.darthkali.kmmbikeshare.datasource.BaseMapper
import de.darthkali.kmmbikeshare.datasource.network.BicycleSharingSystemNetworkObject
import de.darthkali.kmmbikeshare.datasource.network.mapper.BicycleSharingSystemNetworkObjectMapper
import de.darthkali.kmmbikeshare.domain.model.BicycleSharingSystem

class BicycleSharingSystemDbListMapper : BaseMapper<List<BicycleSharingSystem>, List<BicycleSharingSystemNetworkObject>> {

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