package de.darthkali.kmm_bike_share.presentation.ingredient_list

import de.darthkali.kmm_bike_share.domain.model.BicycleSharingSystem

data class BicycleSharingSystemListState(
    val isLoading: Boolean = false,
    val country: String = "",
    val bicycleSharingSystems: List<BicycleSharingSystem> = listOf(),
) {
    // Need secondary constructor to initialize with no args in SwiftUI
    constructor() : this(
        isLoading = false,
        country = "",
        bicycleSharingSystems = listOf(),
    )
}