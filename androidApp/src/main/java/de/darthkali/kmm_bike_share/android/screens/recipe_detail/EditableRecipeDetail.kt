//package de.darthkali.weefood.screens.recipe_detail
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.defaultMinSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.ScaffoldState
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import de.darthkali.weefood.components.Header
//import de.darthkali.weefood.components.button.ButtonStyle
//import de.darthkali.weefood.components.button.CommonButton
//import de.darthkali.weefood.domain.model.Recipe
//import de.darthkali.weefood.presentation.recipe_detail.RecipeDetailEvents
//import de.darthkali.weefood.screens.recipe_detail.components.IngredientCard
//import de.darthkali.weefood.screens.recipe_detail.components.IngredientUnitTextField
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.launch
//
//@ExperimentalCoroutinesApi
//@ExperimentalMaterialApi
//@ExperimentalComposeUiApi
//@ExperimentalFoundationApi
//@Composable
//fun EditableRecipeDetail(
//    recipe: Recipe,
//    onTriggerEvent: (RecipeDetailEvents) -> Unit,
//    onClickAddIngredient: (Int?) -> Unit,
//    scope: CoroutineScope,
//    scaffoldState: ScaffoldState
//) {
//    LazyColumn() {
//        item {
////            Text("Bild")
//            IngredientUnitTextField(
//                input = recipe.name,
//                onInputChanged = {
//                    onTriggerEvent(RecipeDetailEvents.OnUpdateName(it))
//                },
//                label = "Rezeptname",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//            )
//
//            Header(
//                text = "Zutaten pro Portion",
//                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
//            )
//
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 8.dp, bottom = 8.dp)
//            ) {
//                CommonButton(
//                    text = "Zutat hinzufügen",
//                    buttonStyle = ButtonStyle.ADD_BUTTON,
//
//                ) {
//
//                    onTriggerEvent(RecipeDetailEvents.OnSaveRecipe)
//
//                    if (recipe.name != "") {
//                        recipe.databaseId?.let {
//                            if (it != 0) {
//                                onClickAddIngredient(it)
//                            }
//                        }
//                    } else {
//                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Bitte einen Rezeptnamen eingeben!")
//                        }
//                    }
//                }
//            }
//        }
//
//        itemsIndexed(
//            items = recipe.ingredients
//        ) { _, ingredients ->
//            IngredientCard(
//                ingredient = ingredients,
//                onDeleteIngredient = {
//                    onTriggerEvent(
//                        RecipeDetailEvents.OnDeleteIngredient(
//                            it
//                        )
//                    )
//                }, // onDeleteIngredient(it),
//                onTriggerEvent = onTriggerEvent
//            )
//        }
//
//        item {
//            Header(
//                text = "Kochzeit",
//                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
//            )
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//
//                IngredientUnitTextField(
//                    input = recipe.cooking_time.toString(),
//                    onInputChanged = {
//                        var result = 0
//                        if (it != "") {
//                            result = it.toInt()
//                        }
//
//                        onTriggerEvent(
//                            RecipeDetailEvents.OnUpdateCookingTime(
//                                result
//                            )
//                        )
//                    },
//                    label = "Zeit",
//                    modifier = Modifier
//                        .width(120.dp)
//                        .padding(8.dp),
//                )
//
//                IngredientUnitTextField(
//                    input = recipe.cooking_time_unit,
//                    onInputChanged = {
//                        onTriggerEvent(
//                            RecipeDetailEvents.OnUpdateCookingTimeUnit(
//                                it
//                            )
//                        )
//                    },
//                    label = "Einheit",
//                    modifier = Modifier
//                        .width(120.dp)
//                        .padding(8.dp),
//                )
//            }
//            Header(
//                text = "Rezept",
//                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
//            )
//            IngredientUnitTextField(
//                input = recipe.recipeDescription ?: "",
//                onInputChanged = {
//                    onTriggerEvent(RecipeDetailEvents.OnUpdateDescription(it))
//                },
//                label = "Rezept",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .defaultMinSize(minHeight = 100.dp),
//            )
//        }
//    }
//}
