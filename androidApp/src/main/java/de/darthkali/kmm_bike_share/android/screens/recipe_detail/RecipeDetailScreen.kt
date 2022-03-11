//package de.darthkali.weefood.screens.recipe_detail
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.FabPosition
//import androidx.compose.material.FloatingActionButton
//import androidx.compose.material.FloatingActionButtonDefaults
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Scaffold
//import androidx.compose.material.ScaffoldState
//import androidx.compose.material.Snackbar
//import androidx.compose.material.SnackbarHost
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Check
//import androidx.compose.material.icons.filled.Create
//import androidx.compose.material.rememberScaffoldState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import de.darthkali.weefood.domain.model.Recipe
//import de.darthkali.weefood.navigation.NavigationItem
//import de.darthkali.weefood.navigation.TopBar
//import de.darthkali.weefood.presentation.recipe_detail.RecipeDetailEvents
//import de.darthkali.weefood.presentation.recipe_detail.RecipeDetailState
//import de.darthkali.weefood.theme.AppTheme
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.launch
//
//@ExperimentalCoroutinesApi
//@ExperimentalMaterialApi
//@ExperimentalComposeUiApi
//@ExperimentalFoundationApi
//@Composable
//fun NewRecipeScreen(
//    recipeDetailState: RecipeDetailState,
//    editable: Boolean,
//    navController: NavController,
//    onTriggerEvent: (RecipeDetailEvents) -> Unit,
//    onClickAddIngredient: (Int?) -> Unit,
//    onClickSaveRecipeDetailFAB: (Int?) -> Unit,
//    onClickEditRecipeDetailFAB: (Int?) -> Unit,
//    onClickBackInEditableRecipeDetailScreen: (Int?) -> Unit,
//    onClickBackInViewableRecipeDetailScreen: (String) -> Unit,
//) {
//
//    AppTheme {
//        val scaffoldState = rememberScaffoldState()
//        val scope = rememberCoroutineScope()
//        Scaffold(
//            scaffoldState = scaffoldState,
//            snackbarHost = {
//                // reuse default SnackbarHost to have default animation and timing handling
//                SnackbarHost(it) { data ->
//                    // custom snackbar with the custom border
//                    Snackbar(
//                        snackbarData = data
//                    )
//                }
//            },
//            topBar = {
//                if (editable) {
//                    EditableRecipeDetailScreenTopBar(
//                        recipe = recipeDetailState.recipe,
//                        navController = navController,
//                        onClickBackInEditableRecipeDetailScreen = onClickBackInEditableRecipeDetailScreen,
//                        onTriggerEvent = onTriggerEvent,
//                        scope = scope,
//                        scaffoldState = scaffoldState
//                    )
//                } else {
//                    ViewableRecipeDetailScreenTopBar(
//                        recipe = recipeDetailState.recipe,
//                        onClickBackInViewableRecipeDetailScreen = onClickBackInViewableRecipeDetailScreen,
//                    )
//                }
//            },
//            floatingActionButtonPosition = FabPosition.End,
//            floatingActionButton = {
//                if (editable) {
//                    SaveRecipeDetailFAB(
//                        recipe = recipeDetailState.recipe,
//                        onClickSaveRecipeDetailFAB = onClickSaveRecipeDetailFAB,
//                        onTriggerEvent = onTriggerEvent,
//                        scope = scope,
//                        scaffoldState = scaffoldState
//                    )
//                } else {
//                    EditRecipeDetailFAB(
//                        recipe = recipeDetailState.recipe,
//                        onTriggerEvent = onTriggerEvent,
//                        onClickEditRecipeDetailFAB = onClickEditRecipeDetailFAB
//                    )
//                }
//            }
//
//        ) { innerPadding ->
//            Box(modifier = Modifier.padding(innerPadding)) {
//
//                if (editable) {
//                    EditableRecipeDetail(
//                        recipe = recipeDetailState.recipe,
//                        onTriggerEvent = onTriggerEvent,
//                        onClickAddIngredient = onClickAddIngredient,
//                        scope = scope,
//                        scaffoldState = scaffoldState
//                    )
//                } else {
//                    ViewableRecipeDetail(
//                        recipe = recipeDetailState.recipe,
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun SaveRecipeDetailFAB(
//    recipe: Recipe,
//    onTriggerEvent: (RecipeDetailEvents) -> Unit,
//    onClickSaveRecipeDetailFAB: (Int?) -> Unit,
//    scope: CoroutineScope,
//    scaffoldState: ScaffoldState
//) {
//    FloatingActionButton(
//        onClick = {
//            if (recipe.name != "") {
//                onTriggerEvent(RecipeDetailEvents.OnSaveRecipe)
//                onClickSaveRecipeDetailFAB(recipe.databaseId)
//            } else {
//                scope.launch {
//                    scaffoldState.snackbarHostState.showSnackbar("Bitte einen Rezeptnamen eingeben!")
//                }
//            }
//        },
//        backgroundColor = MaterialTheme.colors.primary,
//        elevation = FloatingActionButtonDefaults.elevation(6.dp)
//    ) {
//        Icon(Icons.Filled.Check, "")
//    }
//}
//
//@Composable
//fun EditRecipeDetailFAB(
//    recipe: Recipe,
//    onTriggerEvent: (RecipeDetailEvents) -> Unit,
//    onClickEditRecipeDetailFAB: (Int?) -> Unit,
//) {
//    FloatingActionButton(
//        onClick = {
//            onTriggerEvent(RecipeDetailEvents.OnSaveRecipe)
//            onClickEditRecipeDetailFAB(recipe.databaseId)
//        },
//        backgroundColor = MaterialTheme.colors.primary,
//        elevation = FloatingActionButtonDefaults.elevation(6.dp)
//    ) {
//        Icon(Icons.Filled.Create, "")
//    }
//}
//
//@Composable
//fun EditableRecipeDetailScreenTopBar(
//    recipe: Recipe,
//    navController: NavController,
//    onTriggerEvent: (RecipeDetailEvents) -> Unit,
//    onClickBackInEditableRecipeDetailScreen: (Int?) -> Unit,
//    scope: CoroutineScope,
//    scaffoldState: ScaffoldState
//) {
//
//    TopBar(
//        title =
//        if (recipe.name == "") {
//            "Neues Rezept"
//        } else {
//            recipe.name
//        },
//
//        navigationIcon = Icons.Filled.ArrowBack,
//        navigationIconClickAction = {
//            recipe.databaseId?.let {
//                if (recipe.isRecipeEmpty()) {
//                    onTriggerEvent(RecipeDetailEvents.OnDeleteRecipe(recipe))
//                    navController.navigate(
//                        NavigationItem.RecipeList.route
//                    )
//                } else {
//                    if (recipe.name != "") {
//                        onTriggerEvent(RecipeDetailEvents.OnSaveRecipe)
//                        onClickBackInEditableRecipeDetailScreen(recipe.databaseId)
//                    } else {
//                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Bitte einen Rezeptnamen eingeben!")
//                        }
//                    }
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun ViewableRecipeDetailScreenTopBar(
//    recipe: Recipe,
//    onClickBackInViewableRecipeDetailScreen: (String) -> Unit,
//) {
//    TopBar(
//        title = recipe.name,
//        navigationIcon = Icons.Filled.ArrowBack,
//        navigationIconClickAction = {
//            onClickBackInViewableRecipeDetailScreen(recipe.name)
//        }
//    )
//}
