//package de.darthkali.weefood.screens.recipe_detail
//
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.SavedStateHandle
//import de.darthkali.weefood.domain.model.Recipe
//import de.darthkali.weefood.interactors.recipe.DeleteRecipe
//import de.darthkali.weefood.interactors.recipe.GetRecipe
//import de.darthkali.weefood.interactors.recipe.SaveRecipe
//import de.darthkali.weefood.interactors.recipe_ingredient.DeleteRecipeIngredient
//import de.darthkali.weefood.interactors.recipe_ingredient.GetIngredientsFromRecipe
//import de.darthkali.weefood.presentation.recipe_detail.RecipeDetailEvents
//import de.darthkali.weefood.presentation.recipe_detail.RecipeDetailState
//import de.darthkali.weefood.screens.BaseViewModel
//import de.darthkali.weefood.util.Logger
//import org.koin.core.component.inject
//
//class RecipeDetailViewModel(
//    savedStateHandle: SavedStateHandle,
//) : BaseViewModel() {
//
//    private val logger = Logger("NewRecipeViewModel")
//    private val saveRecipe: SaveRecipe by inject()
//    private val getRecipe: GetRecipe by inject()
//    private val deleteRecipeIngredient: DeleteRecipeIngredient by inject()
//    private val deleteRecipe: DeleteRecipe by inject()
//    private val getIngredientsFromRecipe: GetIngredientsFromRecipe by inject()
//
//    private var _state = mutableStateOf(RecipeDetailState())
//
//    val state: MutableState<RecipeDetailState>
//        get() = _state
//
//    private var _editable = mutableStateOf(false)
//
//    val editable: MutableState<Boolean>
//        get() = _editable
//
//    init {
//        savedStateHandle.get<Boolean>("editable")?.let {
//            editable.value = it
//        }
//        savedStateHandle.get<String>("recipeId")?.let { id ->
//            onTriggerEvent(RecipeDetailEvents.GetRecipe(recipeId = id.toInt()))
//        }
//            ?: kotlin.run {
//                onTriggerEvent((RecipeDetailEvents.OnSaveRecipe))
//            }
//    }
//
//    fun onTriggerEvent(event: RecipeDetailEvents) {
//        when (event) {
//            is RecipeDetailEvents.GetRecipe -> {
//
//                val recipe: Recipe = getRecipe.execute(recipeId = event.recipeId)!!
//                state.value = state.value.copy(recipe = recipe)
//            }
//            is RecipeDetailEvents.OnUpdateName -> {
//                onUpdateRecipe(state.value.recipe.copy(name = event.name))
//            }
//            is RecipeDetailEvents.OnUpdateImage -> {
//                onUpdateRecipe(state.value.recipe.copy(image = event.image))
//            }
//            is RecipeDetailEvents.OnUpdateCookingTime -> {
//                onUpdateRecipe(state.value.recipe.copy(cooking_time = event.cooking_time))
//            }
//            is RecipeDetailEvents.OnUpdateCookingTimeUnit -> {
//                onUpdateRecipe(state.value.recipe.copy(cooking_time_unit = event.cooking_time_unit))
//            }
//            is RecipeDetailEvents.OnUpdateDescription -> {
//                onUpdateRecipe(state.value.recipe.copy(recipeDescription = event.description))
//            }
//            is RecipeDetailEvents.OnUpdateIngredientQuantity -> {
//                val resultRecipe = state.value.recipe
//                resultRecipe.ingredients.forEach {
//                    if (it.internalId == event.ingredientId) {
//                        it.quantity = event.quantity
//                        onUpdateRecipe(resultRecipe)
//                    }
//                }
//            }
//            is RecipeDetailEvents.OnUpdateIngredientQuantityUnit -> {
//                val resultRecipe = state.value.recipe
//                resultRecipe.ingredients.forEach {
//                    if (it.internalId == event.ingredientId) {
//                        it.unit = event.quantityUnit
//                        onUpdateRecipe(resultRecipe)
//                    }
//                }
//            }
//            is RecipeDetailEvents.OnAddIngredient -> {
//                onUpdateRecipe(state.value.recipe.copy(databaseId = saveRecipe.execute(state.value.recipe)))
//            }
//            is RecipeDetailEvents.OnDeleteIngredient -> {
//                if (deleteRecipeIngredient.execute(
//                        state.value.recipe.databaseId!!,
//                        event.ingredient.internalId!!
//                    )
//                ) {
//                    val ingredients =
//                        getIngredientsFromRecipe.execute(state.value.recipe.databaseId!!)
//                    onUpdateRecipe(state.value.recipe.copy(ingredients = ingredients!!))
//                }
//            }
//            is RecipeDetailEvents.OnDeleteRecipe -> {
//                deleteRecipe.execute(recipeId = state.value.recipe.databaseId!!)
//            }
//            is RecipeDetailEvents.OnSaveRecipe -> {
//                onUpdateRecipe(state.value.recipe.copy(databaseId = saveRecipe.execute(state.value.recipe)))
//            }
//            else -> {
//                logger.log("Something went wrong.")
//            }
//        }
//    }
//
//    private fun onUpdateRecipe(recipe: Recipe) {
//        state.value = state.value.copy(recipe = recipe, changed = state.value.changed + 1)
//    }
//}
