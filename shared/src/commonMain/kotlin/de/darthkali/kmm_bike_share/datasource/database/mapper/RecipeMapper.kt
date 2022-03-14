//package de.darthkali.kmm_bike_share.datasource.database.mapper.recipe
//
//import de.darthkali.kmm_bike_share.datasource.BaseMapper
//import de.darthkali.kmm_bike_share.datasource.database.model.RecipeDb
//import de.darthkali.kmm_bike_share.domain.model.Recipe
//
//class RecipeMapper : BaseMapper<Recipe, RecipeDb> {
//
//    override fun mapTo(db: RecipeDb): Recipe {
//        return Recipe(
//            databaseId = db.id,
//            name = db.name,
//            image = db.image,
//            cooking_time = db.cooking_time,
//            cooking_time_unit = db.cooking_time_unit,
//            recipeDescription = db.description,
//            portion = 0,
//        )
//    }
//
//    override fun mapBack(internal: Recipe): RecipeDb {
//        return RecipeDb(
//            id = internal.databaseId ?: 0,
//            name = internal.name,
//            image = internal.image,
//            cooking_time = internal.cooking_time ?: 0,
//            cooking_time_unit = internal.cooking_time_unit,
//            description = internal.recipeDescription,
//        )
//    }
//}
