package de.darthkali.kmmbikeshare.datasource.network.mapper

import de.darthkali.kmmbikeshare.datasource.BaseMapper
import de.darthkali.kmmbikeshare.datasource.network.BicycleSharingSystemNetworkObject
import de.darthkali.kmmbikeshare.domain.model.BicycleSharingSystem

class BicycleSharingSystemNetworkObjectMapper :
    BaseMapper<BicycleSharingSystem, BicycleSharingSystemNetworkObject> {

    override fun mapTo(db: BicycleSharingSystemNetworkObject): BicycleSharingSystem {
        return BicycleSharingSystem(
            bssid = db.bssid ?: "",
            brand = db.brand,
            city = db.city,
            country = db.country,
            site = db.site,
            electric = db.electric,
            currently_active = db.currentlyActive,
        )
    }

    override fun mapBack(internal: BicycleSharingSystem): BicycleSharingSystemNetworkObject {
        return BicycleSharingSystemNetworkObject(
            bssid = internal.bssid,
            brand = internal.brand,
            city = internal.city,
            country = internal.country,
            site = internal.site,
            electric = internal.electric,
            currentlyActive = internal.currently_active,
        )
    }
}
