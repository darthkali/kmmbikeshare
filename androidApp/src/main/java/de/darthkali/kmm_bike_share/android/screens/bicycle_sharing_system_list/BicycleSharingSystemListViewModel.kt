package de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import de.darthkali.kmm_bike_share.android.screens.BaseViewModel
import de.darthkali.kmm_bike_share.domain.model.BicycleSharingSystem
import de.darthkali.kmm_bike_share.interactors.SearchBicycleSharingSystems
import de.darthkali.kmm_bike_share.presentation.ingredient_list.BicycleSharingSystemListEvents
import de.darthkali.kmm_bike_share.presentation.ingredient_list.BicycleSharingSystemListState
import de.darthkali.kmm_bike_share.util.Logger
import org.koin.core.component.inject

class BicycleSharingSystemListViewModel(
    country: String
) : BaseViewModel() {

    private val searchIngredient: SearchBicycleSharingSystems by inject()
    private val logger = Logger("BicycleSharingSystemListViewModel")


    val state: MutableState<BicycleSharingSystemListState> = mutableStateOf(
        BicycleSharingSystemListState()
    )

    init {
        state.value = state.value.copy(country = country)
        this.loadBicycleSharingSystem()
    }

    fun onTriggerEvent(event: BicycleSharingSystemListEvents) {
        when (event) {
            BicycleSharingSystemListEvents.LoadBicycleSharingSystem -> {
                this.loadBicycleSharingSystem()
            }
            BicycleSharingSystemListEvents.SaveAllBicycleSharingSystems -> {
                saveAllBicycleSharingSystems(state.value.bicycleSharingSystems)
            }
            else -> {
                logger.log("Something went wrong.")
            }
        }
    }

    private fun saveAllBicycleSharingSystems(bicycleSharingSystems: List<BicycleSharingSystem>) {

    }

    private fun loadBicycleSharingSystem() {
        searchIngredient.execute(
            country = state.value.country,
        ).collectCommon(viewModelScope) { dataState ->
            state.value = state.value.copy(isLoading = dataState.isLoading)

            dataState.data?.let { bicycleSharingSystems ->
                appendBicycleSharingSystem(bicycleSharingSystems)
                saveAllBicycleSharingSystems(bicycleSharingSystems)
            }
        }

    }

    private fun appendBicycleSharingSystem(bicycleSharingSystems: List<BicycleSharingSystem>) {
        val curr = ArrayList(state.value.bicycleSharingSystems)
        curr.addAll(bicycleSharingSystems)
        state.value = state.value.copy(bicycleSharingSystems = curr)
    }
}
