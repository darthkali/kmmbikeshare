package de.darthkali.kmm_bike_share

import kotlinx.coroutines.CoroutineScope
import org.koin.test.KoinTest

expect abstract class BaseTest() : KoinTest {
    fun <T> runTest(block: suspend CoroutineScope.() -> T)
}
