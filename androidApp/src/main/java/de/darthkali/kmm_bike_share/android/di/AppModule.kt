package de.darthkali.weefood.di

import de.darthkali.weefood.screens.ingredient_list.BicycleSharingSystemListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { BicycleSharingSystemListViewModel() }
//    viewModel { RecipeListViewModel(get()) }
//    viewModel { RecipeDetailViewModel(get()) }
}
