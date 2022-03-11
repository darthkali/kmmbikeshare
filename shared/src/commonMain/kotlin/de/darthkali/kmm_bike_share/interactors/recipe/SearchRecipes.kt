package de.darthkali.kmm_bike_share.interactors.recipe

import de.darthkali.kmm_bike_share.datasource.database.mapper.recipe.RecipeListMapper
import de.darthkali.kmm_bike_share.datasource.database.repository.recipe.RecipeRepository
import de.darthkali.kmm_bike_share.domain.model.Recipe
import de.darthkali.kmm_bike_share.domain.util.DataState
import de.darthkali.kmm_bike_share.util.CommonFlow
import de.darthkali.kmm_bike_share.util.Logger
import de.darthkali.kmm_bike_share.util.asCommonFlow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchRecipes : KoinComponent {

    private val recipeRepository: RecipeRepository by inject()
    private val mapper = RecipeListMapper()
    private val logger = Logger("SearchRecipe")

    /**
     * @param query: String
     * @param page: Int
     *
     * search recipe by name (query)
     * result depends on the page (pagination)
     * emits the result in a data object
     *
     * @return DataState
     */
    fun execute(
        query: String,
        page: Int
    ): CommonFlow<DataState<List<Recipe>>> = flow {
        try {
            emit(DataState.loading())

            val recipeList = mapper.mapTo(
                recipeRepository.searchRecipes(
                    name = query,
                    page = page,
                )
            )
            emit(DataState.data(data = recipeList))
        } catch (e: Exception) {
            logger.log(e.toString())
        }
    }.asCommonFlow()
}
