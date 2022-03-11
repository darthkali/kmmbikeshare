package de.darthkali.weefood.screens.week_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import de.darthkali.kmm_bike_share.android.navigation.NavigationItem
import de.darthkali.kmm_bike_share.mockFactory.Countries
import de.darthkali.weefood.navigation.TopBar
import de.darthkali.weefood.screens.ingredient_list.components.CountryCard
import de.darthkali.weefood.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun CountryListScreen(
) {
    AppTheme() {
        Scaffold(
            topBar = {
                TopBar(
                    title = "Countries",
                )
            },
        ) {
            LazyColumn {
                itemsIndexed(
                    items = Countries().countryList
                ) { index, ingredient ->
                    CountryCard(country = ingredient)
                }
            }
        }
    }
}
