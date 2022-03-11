package de.darthkali.kmm_bike_share.interactors.recipe

import de.darthkali.kmm_bike_share.datasource.database.repository.recipe.RecipeRepository
import de.darthkali.kmm_bike_share.domain.model.Recipe
import de.darthkali.kmm_bike_share.util.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetRecipe : KoinComponent {

    private val recipeRepository: RecipeRepository by inject()
//    private val getIngredientsFromRecipe: GetIngredientsFromRecipe by inject()
    private val logger = Logger("SaveRecipe")

    /**
     * @param recipeId: Int
     *
     * check if we have a valid recipeId?
     *
     * is the response not null, then create a Recipe and return it
     * else place a log message and return null
     *
     * @return Recipe
     */
    fun execute(recipeId: Int): Recipe? {
        return try {
            if (recipeId > 0) {
                recipeRepository.getRecipeById(recipeId)?.let {
                    return Recipe(
                        databaseId = it.id,
                        name = it.name,
                        image = it.image,
                        cooking_time = it.cooking_time,
                        cooking_time_unit = it.cooking_time_unit,
                        recipeDescription = it.description,
                    )
                }
            }
            logger.log("ezept mitR der RecipeId $recipeId konnte nicht gefunden werden")
            null
        } catch (e: Exception) {
            logger.log(e.toString())
            null
        }
    }
}
