package de.darthkali.kmm_bike_share.android.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_detail.BicycleSharingSystemDetailScreen
import de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_list.BicycleSharingSystemListScreen
import de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_list.BicycleSharingSystemListViewModel
import de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_detail.BicycleSharingSystemDetailViewModel
import de.darthkali.kmm_bike_share.android.screens.country_list.CountryListScreen
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
         * Navigation -> CountryList
         */
        composable(
            route = NavigationItem.CountryList.route
        ) {
            CountryListScreen(navController)
        }


        /**
         * Navigation -> BicycleSharingSystemList
         */
        composable(
            route = NavigationItem.BicycleSharingSystemList.route + "?country={country}",
            arguments = listOf(
                navArgument("country") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val viewModel = getViewModel<BicycleSharingSystemListViewModel> {
                parametersOf(backStackEntry.arguments?.getString("country"))
            }

            BicycleSharingSystemListScreen(
                bicycleSharingSystemListState = viewModel.state.value,
                onClickBack = { navController.navigate(NavigationItem.CountryList.route) },
                onOpenBicycleSharingSystem = { bssid ->
                    navController.navigate("${NavigationItem.BicycleSharingSystemDetail.route}?bssid=$bssid")
                },
            )
        }

        /**
         * Navigation -> BicycleSharingSystemDetail
         */
        composable(
            route = NavigationItem.BicycleSharingSystemDetail.route + "?bssid={bssid}",
//            arguments = listOf(
//                navArgument("recipeId") {
//                    type = NavType.IntType
//                }
//            )
        ) { backStackEntry ->
            val viewModel = getViewModel<BicycleSharingSystemDetailViewModel> {
                parametersOf("sdf")
//                parametersOf(backStackEntry.arguments?.getString("recipeId"))
            }

            BicycleSharingSystemDetailScreen(
                bicycleSharingSystemDetailState = viewModel.state.value,
            )
        }
    }
}
