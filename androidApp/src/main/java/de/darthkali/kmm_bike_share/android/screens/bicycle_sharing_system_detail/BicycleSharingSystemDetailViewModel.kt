package de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import de.darthkali.kmm_bike_share.android.screens.BaseViewModel
import de.darthkali.kmm_bike_share.interactors.SearchBicycleSharingSystems
import de.darthkali.kmm_bike_share.presentation.recipe_list.BicycleSharingSystemDetailEvents
import de.darthkali.kmm_bike_share.presentation.recipe_list.BicycleSharingSystemDetailState
import org.koin.core.component.inject

class BicycleSharingSystemDetailViewModel(
//    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {
    private val searchIngredient: SearchBicycleSharingSystems by inject()

    //    private val saveIngredient: SaveIngredient by inject()
//    private val logger = Logger("IngredientListViewModel")


    val state: MutableState<BicycleSharingSystemDetailState> = mutableStateOf(
        BicycleSharingSystemDetailState()
    )

    init {
//        state.value = state.value.copy(country = "United Kingdom")
//        loadIngredients()
    }

    fun onTriggerEvent(event: BicycleSharingSystemDetailEvents) {
        when (event) {
            BicycleSharingSystemDetailEvents.LoadBicycleSharingSystem -> {
                loadIngredients()
            }
            else -> {
//                logger.log("Something went wrong.")
            }
        }
    }

//    private fun saveIngredient(ingredient: Ingredient) {
//        saveIngredient.execute(ingredient, state.value.recipeId).let {
//            logger.log("Ingredients ID was: $it")
//        }
//    }

    private fun loadIngredients() {
//        searchIngredient.execute(
//            country = state.value.country,
//        ).collectCommon(viewModelScope) { dataState ->
//            state.value = state.value.copy(isLoading = dataState.isLoading)
//
//            dataState.data?.let { ingredients ->
////                appendIngredients(ingredients)
//            }
//        }
    }
}
