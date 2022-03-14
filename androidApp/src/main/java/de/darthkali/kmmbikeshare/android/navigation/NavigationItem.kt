package de.darthkali.kmmbikeshare.android.navigation

sealed class NavigationItem(
    var route: String,
) {
    object CountryList : NavigationItem("countryList")
    object BicycleSharingSystemList : NavigationItem("bicycleSharingSystemList")
    object BicycleSharingSystemDetail : NavigationItem("bicycleSharingSystemDetail")
}
