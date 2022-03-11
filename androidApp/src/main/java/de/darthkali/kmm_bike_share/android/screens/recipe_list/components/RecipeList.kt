//package de.darthkali.weefood.screens.recipe_list.components
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import de.darthkali.weefood.components.NothingHere
//import de.darthkali.weefood.datasource.network.IngredientServiceImpl.Companion.PAGINATION_PAGE_SIZE
//import de.darthkali.weefood.domain.model.Recipe
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//
//@ExperimentalMaterialApi
//@ExperimentalCoroutinesApi
//@Composable
//fun RecipeList(
//    loading: Boolean,
//    recipes: List<Recipe>,
//    page: Int,
//    onTriggerNextPage: () -> Unit,
//    onClickOpenRecipe: (Int) -> Unit,
//) {
//    Box(
//        modifier = Modifier
//            .background(color = MaterialTheme.colors.background)
//    ) {
//        if (loading && recipes.isEmpty()) {
//            LoadingRecipeListShimmer(imageHeight = 250.dp)
//        } else if (recipes.isEmpty()) {
//            NothingHere()
//        } else {
//            LazyColumn {
//                itemsIndexed(
//                    items = recipes
//                ) { index, recipe ->
//                    if ((index + 1) >= (page * PAGINATION_PAGE_SIZE) && !loading) {
//                        onTriggerNextPage()
//                    }
//                    RecipeCard(
//                        recipe = recipe,
//                        onClick = {
//                            onClickOpenRecipe(recipe.databaseId!!)
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
