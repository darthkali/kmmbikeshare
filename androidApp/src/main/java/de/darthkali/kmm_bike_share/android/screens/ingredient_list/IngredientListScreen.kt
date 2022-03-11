//package de.darthkali.weefood.screens.ingredient_list
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.Scaffold
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import de.darthkali.weefood.navigation.TopBar
//import de.darthkali.weefood.presentation.ingredient_list.IngredientListEvents
//import de.darthkali.weefood.presentation.ingredient_list.IngredientListState
//import de.darthkali.weefood.screens.ingredient_list.components.IngredientList
//import de.darthkali.weefood.screens.ingredient_list.components.SearchAppBar
//import de.darthkali.weefood.theme.AppTheme
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//
//@ExperimentalCoroutinesApi
//@ExperimentalMaterialApi
//@ExperimentalComposeUiApi
//@ExperimentalFoundationApi
//@Composable
//fun IngredientListScreen(
//    ingredientListState: IngredientListState,
//    onTriggerEvent: (IngredientListEvents) -> Unit,
//    onClickSaveIngredient: (Int?) -> Unit,
//    onClickBack: (Int?) -> Unit,
//) {
//    AppTheme(
//        displayProgressBar = ingredientListState.isLoading,
//    ) {
//        Scaffold(
//            topBar = {
//                TopBar(
//                    title = "Zutaten Suche",
//                    navigationIcon = Icons.Filled.ArrowBack,
//                    navigationIconClickAction = {
//                        onClickBack(ingredientListState.recipeId)
//                    },
//                )
//            },
////            bottomBar = { BottomBar(navController) }
//        ) { innerPadding ->
//            Box(modifier = Modifier.padding(innerPadding)) {
//
//                Column {
//                    SearchAppBar(
//                        query = ingredientListState.query,
//                        onQueryChanged = {
//                            onTriggerEvent(IngredientListEvents.OnUpdateQuery(it))
//                        },
//                        onExecuteSearch = {
//                            onTriggerEvent(IngredientListEvents.NewSearch)
//                        },
//                    )
//
//                    IngredientList(
//                        loading = ingredientListState.isLoading,
//                        ingredients = ingredientListState.ingredients,
//                        page = ingredientListState.page,
//                        onTriggerNextPage = {
//                            onTriggerEvent(IngredientListEvents.NextPage)
//                        },
//                        onSaveIngredient = {
//                            onTriggerEvent(IngredientListEvents.SaveIngredient(it))
//                            onClickSaveIngredient(ingredientListState.recipeId)
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
