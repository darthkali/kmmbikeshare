//package de.darthkali.kmmbikeshare.interactors//package de.darthkali.kmmbikeshare.interactors.recipe
//
//import de.darthkali.kmmbikeshare.datasource.database.mapper.recipe.RecipeMapper
//import de.darthkali.kmmbikeshare.datasource.database.repository.recipe.RecipeRepository
//import de.darthkali.kmmbikeshare.util.Logger
//import org.koin.core.component.KoinComponent
//import org.koin.core.component.inject
//
//class SaveBicycleSharingSystems : KoinComponent {
//
//    private val recipeRepository: RecipeRepository by inject()
////    private val saveRecipeIngredient: SaveRecipeIngredient by inject()
//    private val logger = Logger("SaveRecipe")
//    private val mapper = RecipeMapper()
//
//    /**
//     * @param recipe: Recipe
//     *
//     * exists the recipe in the database, then update it
//     * else insert a new recipe
//     *
//     * save all for all ingredients from the recipe, save it as a recipeIngredient
//     *
//     * @return recipeId
//     */
//    fun execute(recipe: Recipe): Int? {
//        return try {
//
//            val recipeId = if (recipe.databaseId == null || recipe.databaseId == 0) {
//                recipeRepository.insertRecipe(mapper.mapBack(recipe))!!
//            } else {
//                recipeRepository.updateRecipe(mapper.mapBack(recipe))!!
//            }
//
//            recipe.ingredients.forEach {
//                val recipeIngredientDb = RecipeIngredientDb(
//                    recipe_id = recipeId,
//                    ingredient_id = it.internalId!!,
//                    unit = it.unit,
//                    quantity = it.quantity,
//                )
//                saveRecipeIngredient.execute(recipeIngredientDb)
//            }
//            recipeId
//        } catch (e: Exception) {
//            logger.log(e.toString())
//            return null
//        }
//    }
//}
