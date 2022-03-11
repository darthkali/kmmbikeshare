//package de.darthkali.weefood.screens.ingredient_list.components
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
//import de.darthkali.weefood.domain.model.Ingredient
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//
//@ExperimentalMaterialApi
//@ExperimentalCoroutinesApi
//@Composable
//fun IngredientList(
//    loading: Boolean = false,
//    ingredients: List<Ingredient> = listOf(),
//    page: Int = 1,
//    onTriggerNextPage: () -> Unit,
//    onSaveIngredient: (Ingredient) -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .background(color = MaterialTheme.colors.background)
//    ) {
//        if (loading && ingredients.isEmpty()) {
//            LoadingIngredientListShimmer(imageHeight = 250.dp)
//        } else if (ingredients.isEmpty()) {
//            NothingHere()
//        } else {
//            LazyColumn {
//                itemsIndexed(
//                    items = ingredients
//                ) { index, ingredient ->
//                    if ((index + 1) >= (page * PAGINATION_PAGE_SIZE) && !loading) {
//                        onTriggerNextPage()
//                    }
//                    IngredientCard(
//                        ingredientDb = ingredient,
//                        onSaveIngredient = { onSaveIngredient(it) }
//                    )
//                }
//            }
//        }
//    }
//}
