package de.darthkali.kmm_bike_share.android.navigation

sealed class NavigationItem(
    var route: String,
) {
    object CountryList : NavigationItem("countryList")
    object BicycleSharingSystemList : NavigationItem("bicycleSharingSystemList")
    object BicycleSharingSystemDetail : NavigationItem("bicycleSharingSystemDetail")
}
