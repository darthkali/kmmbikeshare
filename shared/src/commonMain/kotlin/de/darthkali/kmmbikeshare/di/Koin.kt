package de.darthkali.kmmbikeshare.di

import de.darthkali.kmmbikeshare.datasource.database.BicycleSharingSystemRepository
import de.darthkali.kmmbikeshare.datasource.database.KmmBikeShareDatabase
import de.darthkali.kmmbikeshare.datasource.network.BicycleSharingSystemService
import de.darthkali.kmmbikeshare.datasource.network.KtorClientFactory
import de.darthkali.kmmbikeshare.interactors.GetBicycleSharingSystem
import de.darthkali.kmmbikeshare.interactors.SearchBicycleSharingSystems
import de.darthkali.kmmbikeshare.interactors.SaveBicycleSharingSystems
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            platformModule(),
            network,
            database,
            interactor
        )
    }

// called by iOS
fun initKoin() = initKoin() {}

expect fun platformModule(): Module

val network = module {
    single { KtorClientFactory() }
    single { BicycleSharingSystemService() }
}

val database = module {
    single { KmmBikeShareDatabase(get()) }
    single { BicycleSharingSystemRepository() }
}

val interactor = module {
    single { SearchBicycleSharingSystems() }
    single { GetBicycleSharingSystem() }
    single { SaveBicycleSharingSystems() }
}
