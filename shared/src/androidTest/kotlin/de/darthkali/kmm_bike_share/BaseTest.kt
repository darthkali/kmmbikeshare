package de.darthkali.kmm_bike_share

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.darthkali.kmm_bike_share.di.database
import de.darthkali.kmm_bike_share.di.interactor
import de.darthkali.kmm_bike_share.di.network
import de.darthkali.kmm_bike_share.di.platformModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule

@RunWith(AndroidJUnit4::class)
actual abstract class BaseTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        androidContext(ApplicationProvider.getApplicationContext())
        androidLogger()
        modules(
            platformModule(),
            network,
            database,
            interactor
        )
    }

    actual fun <T> runTest(
        block: suspend CoroutineScope.() -> T
    ) {
        runBlocking { block() }
    }
}
