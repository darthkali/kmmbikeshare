package de.darthkali.weefood.screens.ingredient_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import de.darthkali.kmm_bike_share.android.screens.BaseViewModel
import de.darthkali.kmm_bike_share.domain.model.BicycleSharingSystem
import de.darthkali.kmm_bike_share.interactors.SearchBicycleSharingSystems
import de.darthkali.kmm_bike_share.presentation.ingredient_list.BicycleSharingSystemListEvents
import de.darthkali.kmm_bike_share.presentation.ingredient_list.BicycleSharingSystemListState
import org.koin.core.component.inject

class BicycleSharingSystemListViewModel(
    country: String
) : BaseViewModel() {

    private val searchIngredient: SearchBicycleSharingSystems by inject()

    //    private val saveIngredient: SaveIngredient by inject()
//    private val logger = Logger("IngredientListViewModel")


    val state: MutableState<BicycleSharingSystemListState> = mutableStateOf(
        BicycleSharingSystemListState()
    )

    init {
        state.value = state.value.copy(country = country)
        loadIngredients()
    }

    fun onTriggerEvent(event: BicycleSharingSystemListEvents) {
        when (event) {
//            BicycleSharingSystemListEvents.LoadIngredient -> {
//                loadIngredients()
//            }
//            is BicycleSharingSystemListEvents.SaveIngredient -> {
//                saveIngredient(event.ingredient)
//            }
//            is BicycleSharingSystemListEvents.OnUpdateQuery -> {
//                state.value = state.value.copy(query = event.query)
//            }
//            else -> {
//                logger.log("Something went wrong.")
//            }
        }
    }

//    private fun saveIngredient(ingredient: Ingredient) {
//        saveIngredient.execute(ingredient, state.value.recipeId).let {
//            logger.log("Ingredients ID was: $it")
//        }
//    }

    private fun loadIngredients() {
        searchIngredient.execute(
            country = state.value.country,
        ).collectCommon(viewModelScope) { dataState ->
            state.value = state.value.copy(isLoading = dataState.isLoading)

            dataState.data?.let { ingredients ->
                appendIngredients(ingredients)
            }
        }


    }

    private fun appendIngredients(ingredients: List<BicycleSharingSystem>) {
        val curr = ArrayList(state.value.bicycleSharingSystems)
        curr.addAll(ingredients)
        state.value = state.value.copy(bicycleSharingSystems = curr)
    }
}
