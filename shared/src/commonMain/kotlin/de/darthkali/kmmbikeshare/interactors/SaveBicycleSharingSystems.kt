package de.darthkali.kmmbikeshare.interactors

import de.darthkali.kmmbikeshare.datasource.database.BicycleSharingSystemRepository
import de.darthkali.kmmbikeshare.datasource.database.mapper.BicycleSharingSystemDbMapper
import de.darthkali.kmmbikeshare.domain.model.BicycleSharingSystem
import de.darthkali.kmmbikeshare.util.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SaveBicycleSharingSystems : KoinComponent {

    private val bicycleSharingSystemRepository: BicycleSharingSystemRepository by inject()
    private val logger = Logger("SaveBicycleSharingSystems")
    private val mapper = BicycleSharingSystemDbMapper()

    /**
     * @param bicycleSharingSystem: BicycleSharingSystem
     *
     * search BicycleSharingSystem by bssid
     * is there a result, then update the BicycleSharingSystem and return the database-id
     * if the result is null, then insert a new BicycleSharingSystem and return the new database-id
     *
     * @return BicycleSharingSystem-ID
     */
    fun execute(bicycleSharingSystem: BicycleSharingSystem): Int? {
        try {
            bicycleSharingSystemRepository.getBicycleSharingSystemByBssid(bicycleSharingSystem.bssid).let {
                return if (it != null) {
                    bicycleSharingSystemRepository.updateBicycleSharingSystemByBssid(mapper.mapBack(bicycleSharingSystem))!!
                } else {
                    bicycleSharingSystemRepository.insertBicycleSharingSystem(mapper.mapBack(bicycleSharingSystem))!!
                }
            }
        } catch (e: Exception) {
            logger.log(e.toString())
            return null
        }
    }
}
