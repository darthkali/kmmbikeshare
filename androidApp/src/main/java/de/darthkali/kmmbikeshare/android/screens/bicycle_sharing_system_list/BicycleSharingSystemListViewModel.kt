package de.darthkali.kmmbikeshare.android.screens.bicycle_sharing_system_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import de.darthkali.kmmbikeshare.android.screens.BaseViewModel
import de.darthkali.kmmbikeshare.domain.model.BicycleSharingSystem
import de.darthkali.kmmbikeshare.interactors.SaveBicycleSharingSystems
import de.darthkali.kmmbikeshare.interactors.SearchBicycleSharingSystems
import de.darthkali.kmmbikeshare.states.BicycleSharingSystemListState
import org.koin.core.component.inject

class BicycleSharingSystemListViewModel(
    country: String
) : BaseViewModel() {

    private val searchBicycleSharingSystems: SearchBicycleSharingSystems by inject()
    private val saveBicycleSharingSystems: SaveBicycleSharingSystems by inject()

    val state: MutableState<BicycleSharingSystemListState> = mutableStateOf(
        BicycleSharingSystemListState()
    )

    init {
        state.value = state.value.copy(country = country)
        this.loadBicycleSharingSystem()
    }

    private fun saveAllBicycleSharingSystems(bicycleSharingSystems: List<BicycleSharingSystem>) {
        bicycleSharingSystems.forEach { bicycleSharingSystem ->
            saveBicycleSharingSystems.execute(bicycleSharingSystem)
        }
    }

    private fun loadBicycleSharingSystem() {
        searchBicycleSharingSystems.execute(
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
