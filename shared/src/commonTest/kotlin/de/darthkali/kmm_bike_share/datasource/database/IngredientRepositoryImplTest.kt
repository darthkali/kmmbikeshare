package de.darthkali.kmm_bike_share.datasource.database

import de.darthkali.kmm_bike_share.BaseTest
import de.darthkali.kmm_bike_share.mockFactory.BicycleSharingSystemMock
import de.darthkali.kmm_bike_share.writeHead
import org.koin.core.component.inject
import kotlin.test.*

class BicycleSharingSystemRepositoryTest : BaseTest() {

    private val bicycleSharingSystemRepository: BicycleSharingSystemRepository by inject()

    @BeforeTest
    fun setup() = runTest {
        writeHead("setup")
        bicycleSharingSystemRepository.getAllBicycleSharingSystems()
//        bicycleSharingSystemRepository.deleteAllBicycleSharingSystems()
//        val bicycleSharingSystems = BicycleSharingSystemMock.bicycleSharingSystemDbList
//
//        for (bicycleSharingSystem in bicycleSharingSystems) {
//            bicycleSharingSystemRepository.insertBicycleSharingSystem(bicycleSharingSystem)
//        }
    }

    @Test
    fun test() = runTest {
        println("test")
    }


    @Test
    fun insert_bicycleSharingSystem_success() = runTest {
        writeHead("insert_bicycleSharingSystem_success")

        for (bicycleSharingSystem in bicycleSharingSystemRepository.getAllBicycleSharingSystems()) {
            println(bicycleSharingSystem.toString())
        }

        bicycleSharingSystemRepository.insertBicycleSharingSystem(BicycleSharingSystemMock.bicycleSharingSystemDb)

        for (bicycleSharingSystem in bicycleSharingSystemRepository.getAllBicycleSharingSystems()) {
            println(bicycleSharingSystem.toString())
        }
        assertEquals(bicycleSharingSystemRepository.getAllBicycleSharingSystems().last(), BicycleSharingSystemMock.bicycleSharingSystemDb)
    }



    @Test
    fun get_all_bicycleSharingSystems_success() = runTest {
        writeHead("get_all_bicycleSharingSystem_success")
        val bicycleSharingSystems = bicycleSharingSystemRepository.getAllBicycleSharingSystems()
        bicycleSharingSystems.forEachIndexed { index, bicycleSharingSystem ->
            println(bicycleSharingSystem.toString())
            assertEquals(
                BicycleSharingSystemMock.bicycleSharingSystemDbList[index].bssid,
                bicycleSharingSystem.bssid
            )
        }
    }
//
//    @Test
//    fun get_bicycleSharingSystem_by_id_success() = runTest {
//        writeHead("get_bicycleSharingSystem_by_id_success")
//        val bicycleSharingSystems = bicycleSharingSystemRepository.getAllBicycleSharingSystems()
//
//        for (bicycleSharingSystemItem in bicycleSharingSystems) {
//            val bicycleSharingSystem = bicycleSharingSystemRepository.getBicycleSharingSystemById(bicycleSharingSystemItem.id)
//            println(bicycleSharingSystem.toString())
//            assertEquals(
//                expected = bicycleSharingSystemItem.id,
//                actual = bicycleSharingSystem?.id,
//            )
//        }
//    }
//
//    @Test
//    fun get_bicycleSharingSystem_by_Bssid_success() = runTest {
//        writeHead("get_bicycleSharingSystem_by_id_success")
//        val bicycleSharingSystems = bicycleSharingSystemRepository.getAllBicycleSharingSystems()
//
//        for (bicycleSharingSystemItem in bicycleSharingSystems) {
//            val bicycleSharingSystem = bicycleSharingSystemRepository.getBicycleSharingSystemById(bicycleSharingSystemItem.id)
//            println(bicycleSharingSystem.toString())
//            assertEquals(
//                expected = bicycleSharingSystemItem.id,
//                actual = bicycleSharingSystem?.id,
//            )
//        }
//    }
//
//    @Test
//    fun delete_all_bicycleSharingSystems_success() = runTest {
//        writeHead("delete_all_bicycleSharingSystems_success")
//        assertTrue(bicycleSharingSystemRepository.getAllBicycleSharingSystems().isNotEmpty())
//        bicycleSharingSystemRepository.deleteAllBicycleSharingSystems()
//
//        assertTrue(
//            bicycleSharingSystemRepository.getAllBicycleSharingSystems().isEmpty(),
//            "Delete All did not work"
//        )
//    }
//
//    @Test
//    fun delete_bicycleSharingSystem_by_id_success() = runTest {
//        writeHead("delete_bicycleSharingSystem_by_id_success")
//
//        bicycleSharingSystemRepository.getAllBicycleSharingSystems().forEachIndexed { index, bicycleSharingSystem ->
//
//            val bicycleSharingSystemId = bicycleSharingSystem.id
//            println("Delete BicycleSharingSyste with ID: $bicycleSharingSystemId")
//            bicycleSharingSystemRepository.deleteBicycleSharingSystemById(bicycleSharingSystemId)
//
//            assertEquals(
//                bicycleSharingSystemRepository.getAllBicycleSharingSystems().size,
//                BicycleSharingSystemMock.bicycleSharingSystemDbList.size - (index + 1),
//            )
//            assertNull(
//                bicycleSharingSystemRepository.getBicycleSharingSystemById(bicycleSharingSystemId)
//            )
//        }
//    }
//
//
//
//    @Test
//    fun update_bicycleSharingSystem_success() = runTest {
//        writeHead("update_bicycleSharingSystem_success")
//
//        for (recipe in bicycleSharingSystemRepository.getAllBicycleSharingSystems()) {
//            println(recipe.toString())
//        }
//
//        bicycleSharingSystemRepository.updateBicycleSharingSystemByBssid(BicycleSharingSystemMock.bicycleSharingSystemDbUpdate)
//
//        for (recipe in bicycleSharingSystemRepository.getAllBicycleSharingSystems()) {
//            println(recipe.toString())
//        }
//        assertEquals(
//            expected = BicycleSharingSystemMock.bicycleSharingSystemDbUpdate,
//            actual = bicycleSharingSystemRepository.getAllBicycleSharingSystems()[BicycleSharingSystemMock.bicycleSharingSystemDbUpdateIndex],
//        )
//    }
}