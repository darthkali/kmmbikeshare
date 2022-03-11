package de.darthkali.kmm_bike_share.presentation.ingredient_list

sealed class BicycleSharingSystemListEvents {
//    object LoadIngredient : IngredientListEvents()
    object NewSearch : BicycleSharingSystemListEvents()
//    object NextPage : IngredientListEvents()
//    data class SaveIngredient(val ingredient: Ingredient) : IngredientListEvents()
//    data class OnUpdateQuery(val query: String) : IngredientListEvents()
}
