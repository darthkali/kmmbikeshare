package de.darthkali.kmmbikeshare.android.di

import de.darthkali.kmmbikeshare.android.screens.bicycle_sharing_system_detail.BicycleSharingSystemDetailViewModel
import de.darthkali.kmmbikeshare.android.screens.bicycle_sharing_system_list.BicycleSharingSystemListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { BicycleSharingSystemListViewModel(get()) }
    viewModel { BicycleSharingSystemDetailViewModel() }
}
