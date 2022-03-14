package de.darthkali.kmmbikeshare.presentation.ingredient_list

import de.darthkali.kmmbikeshare.domain.model.BicycleSharingSystem

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