package de.darthkali.kmm_bike_share.android.di

import de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_detail.BicycleSharingSystemDetailViewModel
import de.darthkali.weefood.screens.ingredient_list.BicycleSharingSystemListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { BicycleSharingSystemListViewModel(get()) }
    viewModel { BicycleSharingSystemDetailViewModel() }
}
