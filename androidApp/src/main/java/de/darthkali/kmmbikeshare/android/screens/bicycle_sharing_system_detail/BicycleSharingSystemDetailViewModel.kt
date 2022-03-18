package de.darthkali.kmmbikeshare.android.screens.bicycle_sharing_system_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import de.darthkali.kmmbikeshare.android.screens.BaseViewModel
import de.darthkali.kmmbikeshare.interactors.GetBicycleSharingSystem
import de.darthkali.kmmbikeshare.states.BicycleSharingSystemDetailState
import org.koin.core.component.inject

class BicycleSharingSystemDetailViewModel(
    bssid: String
) : BaseViewModel() {

    private val getBicycleSharingSystem: GetBicycleSharingSystem by inject()

    val state: MutableState<BicycleSharingSystemDetailState> = mutableStateOf(
        BicycleSharingSystemDetailState()
    )

    init {
        loadBicycleSharingSystem(bssid)
    }

    private fun loadBicycleSharingSystem(bssid: String) {
        val bicycleSharingSystem = getBicycleSharingSystem.execute(bssid)
        if (bicycleSharingSystem != null) {
            state.value = state.value.copy(
                isLoading = true,
                bssid = bicycleSharingSystem.bssid,
                brand = bicycleSharingSystem.brand,
                city = bicycleSharingSystem.city,
                country = bicycleSharingSystem.country,
                site = bicycleSharingSystem.site,
                electric = bicycleSharingSystem.electric,
                currently_active = bicycleSharingSystem.currently_active,
            )
        }
    }
}
