//package de.darthkali.weefood.screens.ingredient_list
//
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.viewModelScope
//import de.darthkali.kmm_bike_share.interactors.recipe.SearchBicycleSharingSystems
//import de.darthkali.weefood.domain.model.Ingredient
//import de.darthkali.weefood.interactors.ingredient.SaveIngredient
//import de.darthkali.weefood.interactors.ingredient.SearchIngredient
//import de.darthkali.weefood.presentation.ingredient_list.IngredientListEvents
//import de.darthkali.weefood.presentation.ingredient_list.IngredientListState
//import de.darthkali.weefood.screens.BaseViewModel
//import de.darthkali.weefood.util.Logger
//import org.koin.core.component.inject
//
//class IngredientListViewModel(
//    recipeId: Int
//) : BaseViewModel() {
//
//    private val searchIngredient: SearchBicycleSharingSystems by inject()
////    private val saveIngredient: SaveIngredient by inject()
////    private val logger = Logger("IngredientListViewModel")
//
////    val state: MutableState<IngredientListState> = mutableStateOf(IngredientListState())
//
//    init {
//        state.value.recipeId = recipeId
//        loadIngredients()
//    }
//
//    fun onTriggerEvent(event: IngredientListEvents) {
//        when (event) {
//            IngredientListEvents.LoadIngredient -> {
//                loadIngredients()
//            }
//            IngredientListEvents.NewSearch -> {
//                newSearch()
//            }
//            IngredientListEvents.NextPage -> {
//                nextPage()
//            }
//            is IngredientListEvents.SaveIngredient -> {
//                saveIngredient(event.ingredient)
//            }
//            is IngredientListEvents.OnUpdateQuery -> {
//                state.value = state.value.copy(query = event.query)
//            }
//            else -> {
//                logger.log("Something went wrong.")
//            }
//        }
//    }
//
//    private fun saveIngredient(ingredient: Ingredient) {
//        saveIngredient.execute(ingredient, state.value.recipeId).let {
//            logger.log("Ingredients ID was: $it")
//        }
//    }
//
//    /**
//     * Get the next page of recipes
//     */
//    private fun nextPage() {
//        state.value = state.value.copy(page = state.value.page + 1)
//        loadIngredients()
//    }
//
//    /**
//     * Perform a new search:
//     * 1. page = 1
//     * 2. list position needs to be reset
//     */
//    private fun newSearch() {
//        state.value = state.value.copy(page = 1, ingredients = listOf())
//        loadIngredients()
//    }
//
//    private fun loadIngredients() {
//        searchIngredient.execute(
//            query = state.value.query,
//            page = state.value.page,
//        ).collectCommon(viewModelScope) { dataState ->
//            state.value = state.value.copy(isLoading = dataState.isLoading)
//
//            dataState.data?.let { ingredients ->
//                appendIngredients(ingredients)
//            }
//        }
//    }
//
//    private fun appendIngredients(ingredients: List<Ingredient>) {
//        val curr = ArrayList(state.value.ingredients)
//        curr.addAll(ingredients)
//        state.value = state.value.copy(ingredients = curr)
//    }
//}
