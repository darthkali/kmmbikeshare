package de.darthkali.kmm_bike_share.di

import de.darthkali.kmm_bike_share.datasource.network.BicycleSharingSystemService
import de.darthkali.kmm_bike_share.datasource.network.KtorClientFactory
import de.darthkali.kmm_bike_share.interactors.SearchBicycleSharingSystems
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
//            database,
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

//val database = module {
//    single { KmmBikeShareDatabase(get()) }
////    single<IngredientRepository> { IngredientRepositoryImpl() }
//    single<RecipeRepository> { RecipeRepositoryImpl() }
////    single<RecipeIngredientRepository> { RecipeIngredientRepositoryImpl() }
////    single<WeekRecipeRepository> { WeekRecipeRepositoryImpl() }
//}

val interactor = module {
    single { SearchBicycleSharingSystems() }
}
