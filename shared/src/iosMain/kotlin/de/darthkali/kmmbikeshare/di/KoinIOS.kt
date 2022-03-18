package de.darthkali.kmmbikeshare.di

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import de.darthkali.kmmbikeshare.datasource.database.KmmBikeShareDatabase
import de.darthkali.kmmbikeshare.datasource.database.KmmBikeShareDatabaseWrapper
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver = NativeSqliteDriver(KmmBikeShareDatabase.Schema, "BikeShareDb.db")
        KmmBikeShareDatabaseWrapper(KmmBikeShareDatabase(driver))
    }
}
