//package de.darthkali.weefood.screens.recipe_list
//
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.viewModelScope
//import de.darthkali.weefood.domain.model.Recipe
//import de.darthkali.weefood.interactors.recipe.SearchRecipes
//import de.darthkali.weefood.presentation.recipe_list.RecipeListEvents
//import de.darthkali.weefood.presentation.recipe_list.RecipeListState
//import de.darthkali.weefood.screens.BaseViewModel
//import de.darthkali.weefood.util.Logger
//import org.koin.core.component.inject
//
//class RecipeListViewModel(
//    query: String = ""
//) : BaseViewModel() {
//
//    private val searchRecipes: SearchRecipes by inject()
//    private val logger = Logger("RecipeListViewModel")
//
//    val state: MutableState<RecipeListState> = mutableStateOf(RecipeListState())
//
//    init {
//        state.value.query = query
//        loadRecipes()
//    }
//
//    fun onTriggerEvent(event: RecipeListEvents) {
//        when (event) {
//            RecipeListEvents.LoadRecipe -> {
//                loadRecipes()
//            }
//            RecipeListEvents.NewSearch -> {
//                newSearch()
//            }
//            RecipeListEvents.NextPage -> {
//                nextPage()
//            }
//            is RecipeListEvents.OnUpdateQuery -> {
//                state.value = state.value.copy(query = event.query)
//            }
//            else -> {
//                logger.log("Something went wrong.")
//            }
//        }
//    }
//
//    /**
//     * Get the next page of recipes
//     */
//    private fun nextPage() {
//        state.value = state.value.copy(page = state.value.page + 1)
//        loadRecipes()
//    }
//
//    /**
//     * Perform a new search:
//     * 1. page = 1
//     * 2. list position needs to be reset
//     */
//    private fun newSearch() {
//        state.value = state.value.copy(page = 1, recipes = listOf())
//        loadRecipes()
//    }
//
//    private fun loadRecipes() {
//        searchRecipes.execute(
//            query = state.value.query,
//            page = state.value.page,
//        ).collectCommon(viewModelScope) { dataState ->
//            state.value = state.value.copy(isLoading = dataState.isLoading)
//
//            dataState.data?.let { recipes ->
//                appendRecipes(recipes)
//            }
//        }
//    }
//
//    private fun appendRecipes(recipes: List<Recipe>) {
//        val curr = ArrayList(state.value.recipes)
//        curr.addAll(recipes)
//        state.value = state.value.copy(recipes = curr)
//    }
//}
