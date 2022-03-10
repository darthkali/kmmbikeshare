package de.darthkali.kmm_bike_share.di

import de.darthkali.kmm_bike_share.datasource.database.KmmBikeShareDatabase
import de.darthkali.kmm_bike_share.datasource.database.repository.recipe.RecipeRepository
import de.darthkali.kmm_bike_share.datasource.database.repository.recipe.RecipeRepositoryImpl
import de.darthkali.kmm_bike_share.datasource.network.IngredientService
import de.darthkali.kmm_bike_share.datasource.network.IngredientServiceImpl
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
//    single { de.darthkali.datasource.kmm_bike_share.network.KtorClientFactory() }
    single<IngredientService> { IngredientServiceImpl() }
}

val database = module {
    single { KmmBikeShareDatabase(get()) }
//    single<IngredientRepository> { IngredientRepositoryImpl() }
    single<RecipeRepository> { RecipeRepositoryImpl() }
//    single<RecipeIngredientRepository> { RecipeIngredientRepositoryImpl() }
//    single<WeekRecipeRepository> { WeekRecipeRepositoryImpl() }
}

val interactor = module {
//    single { SearchBikeShare() }
}
