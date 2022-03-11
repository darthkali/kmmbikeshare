package de.darthkali.kmm_bike_share.datasource.database.repository.recipe

import de.darthkali.kmm_bike_share.datasource.database.model.RecipeDb

interface RecipeRepository {
    fun insertRecipe(recipeDb: RecipeDb): Int?
    fun updateRecipe(recipeDb: RecipeDb): Int?
    fun getAllRecipes(): List<RecipeDb>
    fun getRecipeById(recipeId: Int): RecipeDb?
    fun searchRecipes(name: String, page: Int): List<RecipeDb>
    fun getLastInsertRowId(): Int?
    fun deleteRecipeById(recipeId: Int): Boolean
    fun deleteAllRecipes(): Boolean
}
