package de.darthkali.kmm_bike_share.di

import com.squareup.sqldelight.android.AndroidSqliteDriver
import de.darthkali.kmm_bike_share.datasource.database.KmmBikeShareDatabase
import de.darthkali.kmm_bike_share.datasource.database.KmmBikeShareDatabaseWrapper
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver =
            AndroidSqliteDriver(KmmBikeShareDatabase.Schema, get(), "weeFoodDatabase.db")
        KmmBikeShareDatabaseWrapper(KmmBikeShareDatabase(driver))
    }
}
