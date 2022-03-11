//package de.darthkali.weefood.screens.recipe_detail
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.defaultMinSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import coil.annotation.ExperimentalCoilApi
//import de.darthkali.weefood.components.Header
//import de.darthkali.weefood.domain.model.Recipe
//import de.darthkali.weefood.screens.recipe_list.components.CustomChip
//import de.darthkali.weefood.theme.AppTheme
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//
//@ExperimentalCoroutinesApi
//@ExperimentalMaterialApi
//@ExperimentalComposeUiApi
//@ExperimentalFoundationApi
//@Composable
//fun ViewableRecipeDetail(
//    recipe: Recipe,
//) {
//    LazyColumn() {
//        item {
////            Text("Bild")
//            if (recipe.cooking_time != 0) {
//                CustomChip(
//                    text = "${recipe.cooking_time} ${recipe.cooking_time_unit}",
//                    modifier = Modifier
//                        .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
//                        .defaultMinSize(minWidth = 50.dp)
//                )
//            }
//            Header(
//                text = "Zutaten pro Portion",
//                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
//            )
//
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
//
//                Text(
//                    text = "Zutat",
//                    modifier = Modifier
//                        .padding(start = 8.dp, end = 8.dp),
//                    style = MaterialTheme.typography.h2
//                )
//                Text(
//                    text = "Menge",
//                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
//                    style = MaterialTheme.typography.h2
//                )
//            }
//        }
//        itemsIndexed(
//            items = recipe.ingredients
//        ) { _, ingredients ->
//
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 8.dp, end = 8.dp),
//            ) {
//                Text(
//                    text = ingredients.name ?: "",
//                    style = MaterialTheme.typography.body1
//
//                )
//                Text(
//                    text = "${ingredients.quantity} ${ingredients.unit}",
//                    style = MaterialTheme.typography.body1
//                )
//            }
//        }
//
//        item {
//            Header(
//                text = "Rezept",
//                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
//            )
//            Text(
//                text = recipe.recipeDescription ?: "",
//                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
//            )
//        }
//    }
//}
//
//@ExperimentalFoundationApi
//@ExperimentalCoilApi
//@ExperimentalCoroutinesApi
//@ExperimentalMaterialApi
//@ExperimentalComposeUiApi
//@Preview(showBackground = true)
//@Composable
//fun UserProfileDetailsPreview() {
//    val recipeLong = Recipe(
//        databaseId = 0,
//        name = "Kartoffelbrei mit Sauerkraut und Bratwurs",
//        image = "",
//        cooking_time = 5,
//        cooking_time_unit = "h",
//        recipeDescription = "Hackfleisch in einem großen Topf anbraten. Zwiebel und Knoblauch klein hacken und dazugeben. Karotten schälen, in kleine Scheiben schneiden und zum Hackfleisch geben. Alles 5 Minuten unter gelegentlichem Rühren weiter braten. Tomatenmark hinzugeben und gut vermischen. Dann mit der Brühe ablöschen, aufkochen und bei geringer Hitze 40 Minuten zugedeckt köcheln lassen.\n" +
//            "\n" +
//            "Die Paprika in kleine Sticks schneiden und ca. 10 Minuten vor Ende der Kochzeit hinzufügen. Zum Schluss noch mit Salz und Pfeffer abschmecken.\n" +
//            "\n" +
//            "Anrichten und auf jeden Teller einen Klecks Crème fraîche geben.",
//        portion = 0,
//        ingredients = listOf(),
//    )
//    val recipeShort = Recipe(
//        databaseId = 0,
//        name = "Gyros",
//        image = "",
//        cooking_time = 5,
//        cooking_time_unit = "h",
//        recipeDescription = "",
//        portion = 0,
//        ingredients = listOf(),
//    )
//    val recipeWithoutCookingTime = Recipe(
//        databaseId = 0,
//        name = "Gyros",
//        image = "",
//        cooking_time = 0,
//        cooking_time_unit = "h",
//        recipeDescription = "",
//        portion = 0,
//        ingredients = listOf(),
//    )
//
//    AppTheme() {
//        Column() {
//            ViewableRecipeDetail(recipe = recipeLong)
//        }
//    }
//}
