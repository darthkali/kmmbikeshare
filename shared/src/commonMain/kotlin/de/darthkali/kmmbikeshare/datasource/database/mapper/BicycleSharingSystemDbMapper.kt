package de.darthkali.kmmbikeshare.datasource.database.mapper

import de.darthkali.kmmbikeshare.datasource.BaseMapper
import de.darthkali.kmmbikeshare.datasource.database.BicycleSharingSystemDb
import de.darthkali.kmmbikeshare.domain.model.BicycleSharingSystem

class BicycleSharingSystemDbMapper :
    BaseMapper<BicycleSharingSystem, BicycleSharingSystemDb> {

    override fun mapTo(db: BicycleSharingSystemDb): BicycleSharingSystem {
        return BicycleSharingSystem(
            bssid = db.bssid,
            brand = db.brand,
            city = db.city,
            country = db.country,
            site = db.site,
            electric = db.electric,
            currently_active = db.currently_active,
        )
    }

    override fun mapBack(internal: BicycleSharingSystem): BicycleSharingSystemDb {
        return BicycleSharingSystemDb(
            bssid = internal.bssid,
            brand = internal.brand,
            city = internal.city,
            country = internal.country,
            site = internal.site,
            electric = internal.electric,
            currently_active = internal.currently_active,
        )
    }
}
