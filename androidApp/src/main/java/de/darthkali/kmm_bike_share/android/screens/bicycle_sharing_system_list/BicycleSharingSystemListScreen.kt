package de.darthkali.kmm_bike_share.android.screens.bicycle_sharing_system_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import de.darthkali.kmm_bike_share.android.navigation.TopBar
import de.darthkali.kmm_bike_share.presentation.ingredient_list.BicycleSharingSystemListState
import de.darthkali.weefood.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun BicycleSharingSystemListScreen(
    bicycleSharingSystemListState: BicycleSharingSystemListState,
    onClickBack: () -> Unit,
) {

    AppTheme(
        displayProgressBar = bicycleSharingSystemListState.isLoading,
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    title = bicycleSharingSystemListState.country,
                    navigationIcon = Icons.Filled.ArrowBack,
                    navigationIconClickAction = {
                        onClickBack()
                    },
                )
            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {

                Column {

                    if (bicycleSharingSystemListState.isLoading && bicycleSharingSystemListState.bicycleSharingSystems.isEmpty()) {
                        Text(text = "Loading")
                    } else if (bicycleSharingSystemListState.bicycleSharingSystems.isEmpty()) {
                        Text(text = "Empty")
                    } else {
                        LazyColumn {
                            itemsIndexed(
                                items = bicycleSharingSystemListState.bicycleSharingSystems
                            ) { index, ingredient ->
                                BicycleSharingSystemCard(
                                    bicycleSharingSystem = ingredient,
//                                    onSaveIngredient = { onSaveIngredient(it) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
