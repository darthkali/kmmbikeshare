package de.darthkali.weefood.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.darthkali.kmm_bike_share.android.navigation.NavigationItem
import de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_list.BicycleSharingSystemListScreen
import de.darthkali.weefood.screens.ingredient_list.BicycleSharingSystemListViewModel
import de.darthkali.weefood.screens.week_list.CountryListScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

/**
 * Navigation Class
 * Here we set the Routes for the App
 *
 * @author Danny Steinbrecher
 */
@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationItem.CountryList.route) {

        /**
         * Navigation -> WeekList
         */
        composable(
            route = NavigationItem.CountryList.route
        ) {
            CountryListScreen()
        }


        /**
         * Navigation -> IngredientList
         */
        composable(
            route = NavigationItem.BicycleSharingSystemList.route // + "/{recipeId}",
//            arguments = listOf(
//                navArgument("recipeId") {
//                    type = NavType.IntType
//                }
//            )
        ) { backStackEntry ->
            val viewModel = getViewModel<BicycleSharingSystemListViewModel> {
                parametersOf("sdf")
//                parametersOf(backStackEntry.arguments?.getString("recipeId"))
            }

            BicycleSharingSystemListScreen(
                bicycleSharingSystemListState = viewModel.state.value,
            )
        }




    }
}
