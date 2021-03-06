package de.darthkali.kmmbikeshare.android.screens.bicycle_sharing_system_detail

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
import de.darthkali.kmmbikeshare.android.navigation.TopBar
import de.darthkali.kmmbikeshare.android.theme.AppTheme
import de.darthkali.kmmbikeshare.states.BicycleSharingSystemDetailState
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun BicycleSharingSystemDetailScreen(
    bicycleSharingSystemDetailState: BicycleSharingSystemDetailState,
    onClickBack: (String) -> Unit,
) {

    AppTheme {
        Scaffold(
            topBar = {
                TopBar(
                    title = bicycleSharingSystemDetailState.brand ?: "",
                    navigationIcon = Icons.Filled.ArrowBack,
                    navigationIconClickAction = {
                        onClickBack(bicycleSharingSystemDetailState.country!!)
                    },
                )
            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {

                Column {
                    Row() {
                        Text(text = "Brand: ")
                        Text(text = bicycleSharingSystemDetailState.brand ?: "")
                    }
                    Row() {
                        Text(text = "City: ")
                        Text(text = bicycleSharingSystemDetailState.city ?: "")
                    }
                    Row() {
                        Text(text = "Country: ")
                        Text(text = bicycleSharingSystemDetailState.country ?: "")
                    }
                    Row() {
                        Text(text = "Site: ")
                        Text(text = bicycleSharingSystemDetailState.site ?: "")
                    }
                    Row() {
                        Text(text = "Electric: ")
                        Text(text = bicycleSharingSystemDetailState.electric ?: "")
                    }
                    Row() {
                        Text(text = "Currently_active: ")
                        Text(text = bicycleSharingSystemDetailState.currently_active ?: "")
                    }
                }
            }
        }
    }
}
