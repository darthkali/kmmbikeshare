package de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import de.darthkali.kmm_bike_share.presentation.recipe_list.BicycleSharingSystemDetailState
import de.darthkali.kmm_bike_share.android.navigation.TopBar
import de.darthkali.weefood.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun BicycleSharingSystemDetailScreen(
    bicycleSharingSystemDetailState: BicycleSharingSystemDetailState,
) {

    AppTheme(
        displayProgressBar = bicycleSharingSystemDetailState.isLoading,
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    title = bicycleSharingSystemDetailState.brand ?: "",
                    navigationIcon = Icons.Filled.ArrowBack,
                    navigationIconClickAction = {
//                        onClickBack(bicycleSharingSystemListState.recipeId)
                    },
                )
            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {

                Column {
                    Row() {
                        Text(text = "brand: ")
                        Text(text = bicycleSharingSystemDetailState.brand ?: "")
                    }

                    Row() {
                        Text(text = "city: ")
                        Text(text = bicycleSharingSystemDetailState.city ?: "")
                    }

                    Row() {
                        Text(text = "country: ")
                        Text(text = bicycleSharingSystemDetailState.country ?: "")
                    }
                    Row() {
                        Text(text = "site: ")
                        Text(text = bicycleSharingSystemDetailState.site ?: "")
                    }
                    Row() {
                        Text(text = "electric: ")
                        Text(text = bicycleSharingSystemDetailState.electric ?: "")
                    }
                    Row() {
                        Text(text = "currently_active: ")
                        Text(text = bicycleSharingSystemDetailState.currently_active ?: "")
                    }

                }
            }
        }
    }
}


