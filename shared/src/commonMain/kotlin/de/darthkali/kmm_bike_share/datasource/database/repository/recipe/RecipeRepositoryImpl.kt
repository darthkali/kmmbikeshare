package de.darthkali.kmm_bike_share.datasource.database.repository.recipe

import de.darthkali.kmm_bike_share.datasource.database.KmmBikeShareDatabaseWrapper
import de.darthkali.kmm_bike_share.datasource.database.model.RecipeDb
import de.darthkali.kmm_bike_share.util.Logger
import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RecipeRepositoryImpl : RecipeRepository, KoinComponent {

    private val weeFoodDatabase: KmmBikeShareDatabaseWrapper by inject()
    private val weeFoodDatabaseQueries = weeFoodDatabase.instance.bikeShareDbQueries
    private val logger = Logger("RecipeRepositoryImpl")

    override fun insertRecipe(recipeDb: RecipeDb): Int? {
        TODO("Not yet implemented")
    }

    override fun updateRecipe(recipeDb: RecipeDb): Int? {
        TODO("Not yet implemented")
    }

    override fun getAllRecipes(): List<RecipeDb> {
        TODO("Not yet implemented")
    }

    override fun getRecipeById(recipeId: Int): RecipeDb? {
        TODO("Not yet implemented")
    }

    override fun searchRecipes(name: String, page: Int): List<RecipeDb> {
        TODO("Not yet implemented")
    }

    override fun getLastInsertRowId(): Int? {
        TODO("Not yet implemented")
    }

    override fun deleteRecipeById(recipeId: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteAllRecipes(): Boolean {
        TODO("Not yet implemented")
    }

    //    override fun insertRecipe(recipeDb: RecipeDb): Int? {
//        return try {
//            weeFoodDatabaseQueries.insertBikeShare(
//                null,
//                name = recipeDb.name,
//                image = recipeDb.image ?: "no.jpg"
//            )
//            logger.log("Inserting ${recipeDb.name} into database")
//            weeFoodDatabaseQueries.getLastInsertRowId().executeAsOne().toInt()
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            null
//        }
//    }
//
//    override fun updateRecipe(recipeDb: RecipeDb): Int? {
//        return try {
//            weeFoodDatabaseQueries.updateRecipe(
//                name = recipeDb.name,
//                image = recipeDb.image ?: "no.jpg",
//                cooking_time = recipeDb.cooking_time,
//                cooking_time_unit = recipeDb.cooking_time_unit,
//                description = recipeDb.description,
//                id = recipeDb.id.toLong()
//            )
//            logger.log("Updated ${recipeDb.name} in database")
//            recipeDb.id
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            null
//        }
//    }
//
//    override fun getAllRecipes(): List<RecipeDb> {
//        return try {
//            logger.log("Get All Recipes from database")
//            weeFoodDatabaseQueries.getAllRecipes(
//                pageSize = 100, // TODO replace with parameter
//                offset = 0 // TODO replace with parameter
//            ).executeAsList().toRecipeList()
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            listOf()
//        }
//    }
//
//    override fun getRecipeById(recipeId: Int): RecipeDb? {
//        return try {
//            logger.log("Get Recipe from database by ID")
//            weeFoodDatabaseQueries.getRecipeById(
//                id = recipeId.toLong()
//            ).executeAsOne().toRecipe()
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            null
//        }
//    }
//
//    override fun getLastInsertRowId(): Int? {
//        return try {
//            logger.log("Get last insert row id")
//            weeFoodDatabaseQueries.getLastInsertRowId().executeAsOne().toInt()
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            null
//        }
//    }
//
//    override fun searchRecipes(name: String, page: Int): List<RecipeDb> {
//        return try {
//            logger.log("Search Recipes in database")
//            weeFoodDatabaseQueries.searchRecipes(
//                query = name,
//                pageSize = 30.toLong(),
//                offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong(),
//            ).executeAsList().toRecipeList()
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            listOf()
//        }
//    }
//
//    override fun deleteRecipeById(recipeId: Int): Boolean {
//        return try {
//            logger.log("Delete Recipe from database by ID")
//            weeFoodDatabaseQueries.deleteRecipeById(id = recipeId.toLong())
//            true
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            false
//        }
//    }
//
//    override fun deleteAllRecipes(): Boolean {
//        return try {
//            logger.log("Delete all Recipes from database")
//            weeFoodDatabaseQueries.deleteAllRecipes()
//            true
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            false
//        }
//    }
//
//    /*
//-- -----------------------------------------------------
//-- recipe_Entity
//-- -----------------------------------------------------
//  id            INTEGER             NOT NULL PRIMARY KEY AUTOINCREMENT,
//  name          TEXT                NOT NULL,
//  image         TEXT,
//  cooking_time  INTEGER AS Integer  NOT NULL,
//  unit          TEXT                NOT NULL,
//  description   TEXT
//-- -----------------------------------------------------
//*/
//
//    fun Bike_share_Entity.toRecipe(): RecipeDb {
//        return RecipeDb(
//            id = id.toInt(),
//            name = name,
//            image = image,
//            cooking_time = cooking_time,
//            cooking_time_unit = cooking_time_unit,
//            description = description
//        )
//    }
//
//    fun List<Bike_share_Entity>.toRecipeList(): List<RecipeDb> {
//        return map { it.toRecipe() }
//    }
}
