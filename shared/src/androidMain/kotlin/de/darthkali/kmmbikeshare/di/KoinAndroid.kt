package de.darthkali.kmmbikeshare.di

import com.squareup.sqldelight.android.AndroidSqliteDriver
import de.darthkali.kmmbikeshare.datasource.database.KmmBikeShareDatabase
import de.darthkali.kmmbikeshare.datasource.database.KmmBikeShareDatabaseWrapper
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver =
            AndroidSqliteDriver(KmmBikeShareDatabase.Schema, get(), "BikeShareDb.db")
        KmmBikeShareDatabaseWrapper(KmmBikeShareDatabase(driver))
    }
}
