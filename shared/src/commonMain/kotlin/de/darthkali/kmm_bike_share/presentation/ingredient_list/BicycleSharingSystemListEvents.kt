package de.darthkali.kmm_bike_share.presentation.ingredient_list

sealed class BicycleSharingSystemListEvents {
    object LoadBicycleSharingSystem : BicycleSharingSystemListEvents()
    object SaveAllBicycleSharingSystems : BicycleSharingSystemListEvents()
}
