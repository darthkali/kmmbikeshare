package de.darthkali.kmmbikeshare.presentation.ingredient_list

sealed class BicycleSharingSystemListEvents {
    object LoadBicycleSharingSystem : BicycleSharingSystemListEvents()
    object SaveAllBicycleSharingSystems : BicycleSharingSystemListEvents()
}
