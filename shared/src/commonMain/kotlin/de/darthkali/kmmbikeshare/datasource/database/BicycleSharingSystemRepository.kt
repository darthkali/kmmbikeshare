package de.darthkali.kmmbikeshare.datasource.database

import de.darthkali.kmmbikeshare.util.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BicycleSharingSystemRepository : KoinComponent {

    private val bicycleSharingSystemDatabase: KmmBikeShareDatabaseWrapper by inject()
    private val bicycleSharingSystemDatabaseQueries =
        bicycleSharingSystemDatabase.instance.bikeShareDbQueries
    private val logger = Logger("BicycleSharingSystemRepository")

    fun deleteAllBicycleSharingSystems(): Boolean {
        return try {
            logger.log("Delete all BicycleSharingSystems from database")
            bicycleSharingSystemDatabaseQueries.deleteAllBikeShares()
            true
        } catch (e: Exception) {
            logger.log(e.toString())
            false
        }
    }

    fun insertBicycleSharingSystem(bicycleSharingSystem: BicycleSharingSystemDb): Int? {
        return try {
            bicycleSharingSystemDatabaseQueries.insertBikeShare(
                id = null,
                bssid = bicycleSharingSystem.bssid,
                brand = bicycleSharingSystem.brand,
                city = bicycleSharingSystem.city,
                country = bicycleSharingSystem.country,
                site = bicycleSharingSystem.site,
                electric = bicycleSharingSystem.electric,
                currently_active = bicycleSharingSystem.currently_active,
            )
            logger.log("Inserting ${bicycleSharingSystem.bssid} into database")
            bicycleSharingSystemDatabaseQueries.getLastInsertRowId().executeAsOne().toInt()
        } catch (e: Exception) {
            logger.log(e.toString())
            null
        }
    }

    fun getAllBicycleSharingSystems(): List<BicycleSharingSystemDb> {
        return try {
            logger.log("Get All BicycleSharingSystem from database")
            bicycleSharingSystemDatabaseQueries.getAllBikeShares().executeAsList().toBicycleSharingSystemDbList()
        } catch (e: Exception) {
            logger.log(e.toString())
            listOf()
        }
    }

    fun getBicycleSharingSystemById(bicycleSharingSystemId: Int): BicycleSharingSystemDb? {
        return try {
            logger.log("Get BicycleSharingSystemDb from database by ID")
            bicycleSharingSystemDatabaseQueries.getBikeShareById(
                id = bicycleSharingSystemId.toLong()
            ).executeAsOne().toBicycleSharingSystemDb()
        } catch (e: Exception) {
            logger.log(e.toString())
            null
        }
    }

    fun getBicycleSharingSystemByBssid(bssid: String): BicycleSharingSystemDb? {
        return try {
            logger.log("Get BicycleSharingSystem from database by ApiID")
            bicycleSharingSystemDatabaseQueries.getBikeShareByBssid(
                bssid = bssid
            ).executeAsOne().toBicycleSharingSystemDb()
        } catch (e: Exception) {
            logger.log(e.toString())
            null
        }
    }

    fun deleteBicycleSharingSystemById(bicycleSharingSystemId: Int): Boolean {
        return try {
            logger.log("Delete BicycleSharingSystem from database by ID")
            bicycleSharingSystemDatabaseQueries.deleteBikeShareById(id = bicycleSharingSystemId.toLong())
            true
        } catch (e: Exception) {
            logger.log(e.toString())
            false
        }
    }

    fun updateBicycleSharingSystemByBssid(bicycleSharingSystemDbUpdate: BicycleSharingSystemDb): Int? {
        return try {
            bicycleSharingSystemDatabaseQueries.updateBikeShare(
                brand = bicycleSharingSystemDbUpdate.brand,
                city = bicycleSharingSystemDbUpdate.city,
                country = bicycleSharingSystemDbUpdate.country,
                site = bicycleSharingSystemDbUpdate.site,
                electric = bicycleSharingSystemDbUpdate.electric,
                currently_active = bicycleSharingSystemDbUpdate.currently_active,
                bssid = bicycleSharingSystemDbUpdate.bssid
            )
            logger.log("Updated ${bicycleSharingSystemDbUpdate.brand} in database")
            bicycleSharingSystemDatabaseQueries.getBikeShareByBssid(bicycleSharingSystemDbUpdate.bssid)
                .executeAsOne().id.toInt()
        } catch (e: Exception) {
            logger.log(e.toString())
            null
        }
    }

    fun Bike_share_Entity.toBicycleSharingSystemDb(): BicycleSharingSystemDb {
        return BicycleSharingSystemDb(
            databaseId = id.toInt(),
            bssid = bssid,
            brand = brand,
            city = city,
            country = country,
            site = site,
            electric = electric,
            currently_active = currently_active,
        )
    }

    fun List<Bike_share_Entity>.toBicycleSharingSystemDbList(): List<BicycleSharingSystemDb> {
        return map { it.toBicycleSharingSystemDb() }
    }
}
