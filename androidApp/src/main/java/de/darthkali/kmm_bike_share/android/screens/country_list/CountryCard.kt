package de.darthkali.weefood.screens.ingredient_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.darthkali.kmm_bike_share.domain.model.BicycleSharingSystem
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun CountryCard(
    country: String,
//    onSaveIngredient: (Ingredient) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
                start = 16.dp,
                end = 16.dp
            )
            .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = country
                        ?: "", // if ingredient.name == null, then set "" as text
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                    style = typography.h2
                )
            }
        }
    }
}

// @ExperimentalCoroutinesApi
// @ExperimentalMaterialApi
// @ExperimentalComposeUiApi
// @Preview(showBackground = true)
// @Composable
// fun UserProfileDetailsPreview() {
//    val apple = Ingredient(
//        id = 1,
//        name = "Apfel",
//        image = "apple.img",
// //        aisle = "meat",
// //        possibleUnits = listOf(),
//    )
//    AppTheme() {
//        IngredientCard(ingredient = apple)
//    }
//
// }
