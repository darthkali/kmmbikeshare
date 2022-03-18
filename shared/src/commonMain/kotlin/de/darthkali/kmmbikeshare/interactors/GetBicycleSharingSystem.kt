package de.darthkali.kmmbikeshare.interactors

import de.darthkali.kmmbikeshare.datasource.database.BicycleSharingSystemRepository
import de.darthkali.kmmbikeshare.domain.model.BicycleSharingSystem
import de.darthkali.kmmbikeshare.util.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBicycleSharingSystem : KoinComponent {

    private val bicycleSharingSystemRepository: BicycleSharingSystemRepository by inject()
    private val logger = Logger("GetBicycleSharingSystem")

    /**
     * @param bssid: Int
     *
     * check if we have a valid bssid?
     *
     * is the response is not null, then create a BicycleSharingSystem and return it
     * else place a log message and return null
     *
     * @return BicycleSharingSystem
     */
    fun execute(bssid: String): BicycleSharingSystem? {
        return try {
            if (bssid.isBlank().not()) {
                bicycleSharingSystemRepository.getBicycleSharingSystemByBssid(bssid)?.let {
                    return BicycleSharingSystem(
                        bssid = it.bssid,
                        brand = it.brand,
                        city = it.city,
                        country = it.country,
                        site = it.site,
                        electric = it.electric,
                        currently_active = it.currently_active,
                    )
                }
            }
            logger.log("BicycleSharingSystem mit der bssid $bssid konnte nicht gefunden werden")
            null
        } catch (e: Exception) {
            logger.log(e.toString())
            null
        }
    }
}
