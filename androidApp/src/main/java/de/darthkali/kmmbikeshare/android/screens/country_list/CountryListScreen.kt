package de.darthkali.kmmbikeshare.android.screens.country_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import de.darthkali.kmmbikeshare.android.navigation.TopBar
import de.darthkali.kmmbikeshare.android.theme.AppTheme
import de.darthkali.kmmbikeshare.mockFactory.Countries
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun CountryListScreen(
    navController: NavController
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
                ) { _, country ->
                    CountryCard(
                        country = country,
                        navController = navController
                    )
                }

        }
    }
}
