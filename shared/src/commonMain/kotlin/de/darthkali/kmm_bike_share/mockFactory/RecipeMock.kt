//package de.darthkali.kmm_bike_share.mockFactory
//
//import de.darthkali.kmm_bike_share.datasource.database.model.RecipeDb
//import de.darthkali.kmm_bike_share.domain.model.Recipe
//
//object RecipeMock {
//
//    // -----------------------------------------------------
//    // Member
//    // -----------------------------------------------------
//
//    val shortDescription = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam " +
//        "nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam " +
//        "voluptua. At vero eos et accusam."
//
//    val longDescription = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam " +
//        "nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam " +
//        "voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita " +
//        "kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem " +
//        "ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
//        "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
//        "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata " +
//        "sanctus est Lorem ipsum dolor sit amet."
//
//    // -----------------------------------------------------
//    // Recipe Database Mock
//    // -----------------------------------------------------
//    val recipeDb = RecipeDb(
//        name = "Spinatauflauf",
//        image = "spinatauflauf.jpg",
//        cooking_time = 20,
//        cooking_time_unit = "min",
//        description = longDescription
//    )
//
//    val recipeListDb = listOf(
//        RecipeDb(
//            name = "Kartoffelbrei mit Sauerkraut und Bratwurs",
//            image = "kartoffelbrei_sauerkraut_bratwurst.jpg",
//            cooking_time = 120,
//            cooking_time_unit = "min",
//            description = longDescription
//        ),
//        RecipeDb(
//            name = "Tomentensuppe",
//            image = "tomentensuppe.jpg",
//            cooking_time = 90,
//            cooking_time_unit = "min",
//            description = longDescription
//        ),
//        RecipeDb(
//            name = "Tomaten Hirse Salat",
//            image = "tomaten_hirse_salat.jpg",
//            cooking_time = 20,
//            cooking_time_unit = "min",
//            description = longDescription
//        ),
//        RecipeDb(
//            name = "Gebackener Schafskäse",
//            image = "gebackener_schafskaese.jpg",
//            cooking_time = 20,
//            cooking_time_unit = "min",
//            description = longDescription
//        )
//    )
//
//    const val searchName = "Kartoffelbrei"
//    const val searchResponseCount = 3
//
//    val recipeListForSearchByName = listOf(
//        RecipeDb(
//            name = "$searchName mit Sauerkraut und Bratwurs",
//            image = "true",
//            cooking_time = 120,
//            cooking_time_unit = "min",
//            description = longDescription
//        ),
//        RecipeDb(
//            name = "Tomentensuppe $searchName",
//            image = "true",
//            cooking_time = 90,
//            cooking_time_unit = "min",
//            description = longDescription
//        ),
//        RecipeDb(
//            name = "Tomaten Hirse Salat",
//            image = "false",
//            cooking_time = 20,
//            cooking_time_unit = "min",
//            description = longDescription
//        ),
//        RecipeDb(
//            name = "Gebackener  $searchName Schafskäse",
//            image = "true",
//            cooking_time = 20,
//            cooking_time_unit = "min",
//            description = longDescription
//        )
//    )
//
//    const val recipeDbUpdateIndex = 2
//    val recipeDbUpdate = RecipeDb(
//        id = recipeDbUpdateIndex + 1,
//        name = "${recipeListDb[recipeDbUpdateIndex].name} update",
//        image = "${recipeListDb[recipeDbUpdateIndex].image} update",
//        cooking_time = recipeListDb[recipeDbUpdateIndex].cooking_time + 1,
//        cooking_time_unit = "${recipeListDb[recipeDbUpdateIndex].cooking_time_unit} update",
//        description = "${recipeListDb[recipeDbUpdateIndex].description} update"
//    )
//
//    // -----------------------------------------------------
//    // Recipe Domain Mock
//    // -----------------------------------------------------
//    val recipe = Recipe(
//        name = "Spinatauflauf",
//        image = "spinatauflauf.jpg",
//        cooking_time = 20,
//        cooking_time_unit = "min",
//        recipeDescription = longDescription,
//        portion = 2,
//    )
//
//    val recipeList = listOf(
//        Recipe(
//            name = "Kartoffelbrei mit Sauerkraut und Bratwurs",
//            image = "kartoffelbrei_sauerkraut_bratwurst.jpg",
//            cooking_time = 120,
//            cooking_time_unit = "min",
//            recipeDescription = longDescription,
//            portion = 2,
//        ),
//        Recipe(
//            name = "Tomentensuppe",
//            image = "tomentensuppe.jpg",
//            cooking_time = 90,
//            cooking_time_unit = "min",
//            recipeDescription = longDescription,
//            portion = 2,
//
//        ),
//        Recipe(
//            name = "Tomaten Hirse Salat",
//            image = "tomaten_hirse_salat.jpg",
//            cooking_time = 20,
//            cooking_time_unit = "min",
//            recipeDescription = longDescription,
//            portion = 2,
//        ),
//        Recipe(
//            name = "Gebackener Schafskäse",
//            image = "gebackener_schafskaese.jpg",
//            cooking_time = 20,
//            cooking_time_unit = "min",
//            recipeDescription = longDescription,
//            portion = 2,
//        )
//    )
//
//    const val recipeUpdateIndex = 2
//
//    val recipeUpdate = Recipe(
//        databaseId = recipeUpdateIndex + 1,
//        name = "${recipeList[recipeDbUpdateIndex].name} update",
//        image = "${recipeList[recipeDbUpdateIndex].image} update",
//        cooking_time = recipeList[recipeDbUpdateIndex].cooking_time!! + 1,
//        cooking_time_unit = "${recipeList[recipeDbUpdateIndex].cooking_time_unit} update",
//        recipeDescription = "${recipeList[recipeDbUpdateIndex].recipeDescription} update",
//        portion = recipeList[recipeDbUpdateIndex].portion!! + 1,
//    )
//}
