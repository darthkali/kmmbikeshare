package de.darthkali.kmmbikeshare.presentation.recipe_list

data class BicycleSharingSystemDetailState(
    val isLoading: Boolean = false,
    var brand: String? = "",
    var city: String? = "",
    var country: String? = "",
    var site: String? = "",
    var electric: String? = "no",
    var currently_active: String? = "no",
) {
    // Need secondary constructor to initialize with no args in SwiftUI
    constructor() : this(
        isLoading = false,
        brand = "",
        city = "",
        country = "",
        site = "",
        electric = "no",
        currently_active = "no",
    )
}