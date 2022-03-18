package de.darthkali.kmmbikeshare

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.darthkali.kmmbikeshare.di.database
import de.darthkali.kmmbikeshare.di.interactor
import de.darthkali.kmmbikeshare.di.network
import de.darthkali.kmmbikeshare.di.platformModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule

@RunWith(AndroidJUnit4::class)
actual abstract class BaseTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
        androidContext(ApplicationProvider.getApplicationContext())
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
