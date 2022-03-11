package de.darthkali.kmm_bike_share.di

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import de.darthkali.kmm_bike_share.datasource.database.KmmBikeShareDatabase
import de.darthkali.kmm_bike_share.datasource.database.KmmBikeShareDatabaseWrapper
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver = NativeSqliteDriver(KmmBikeShareDatabase.Schema, "BikeShareDb.db")
        KmmBikeShareDatabaseWrapper(KmmBikeShareDatabase(driver))
    }
}
