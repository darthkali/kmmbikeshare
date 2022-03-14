//package de.darthkali.weefood.datasource.database.repository.recipe
//
//import de.darthkali.weefood.BaseTest
//import de.darthkali.weefood.datasource.database.model.RecipeDb
//import de.darthkali.weefood.mockFactory.RecipeMock
//import de.darthkali.weefood.writeHead
//import org.koin.core.component.inject
//import kotlin.test.BeforeTest
//import kotlin.test.Test
//import kotlin.test.assertEquals
//import kotlin.test.assertNull
//import kotlin.test.assertTrue
//
//class RecipeRepositoryImplTest : BaseTest() {
//
//    private val recipeRepository: RecipeRepository by inject()
//
//    @BeforeTest
//    fun setup() = runTest {
//        writeHead("setup")
//        recipeRepository.deleteAllRecipes()
//        val recipes = RecipeMock.recipeListDb
//
//        for (recipe in recipes) {
//            recipeRepository.insertRecipe(recipe)
//        }
//    }
//
//    @Test
//    fun get_all_recipes_success() = runTest {
//        writeHead("get_all_recipes_success")
//        val recipes = recipeRepository.getAllRecipes()
//        recipes.forEachIndexed { index, recipe ->
//            println(recipe.toString())
//            assertEquals(
//                expected = RecipeMock.recipeListDb[index].name,
//                actual = recipe.name
//            )
//        }
//    }
//
//    @Test
//    fun get_recipe_by_id_success() = runTest {
//        writeHead("get_recipe_by_id_success")
//
//        val recipes = recipeRepository.getAllRecipes()
//
//        for (recipeItem in recipes) {
//            val recipe = recipeRepository.getRecipeById(recipeItem.id)
//            println(recipe.toString())
//            assertEquals(
//                expected = recipeItem.id,
//                actual = recipe?.id,
//            )
//        }
//    }
//
//    @Test
//    fun search_recipes_success() = runTest {
//        writeHead("search_recipes_success")
//
//        recipeRepository.deleteAllRecipes()
//        val recipes = RecipeMock.recipeListForSearchByName
//
//        for (recipe in recipes) {
//            recipeRepository.insertRecipe(recipe)
//        }
//
//        for (recipe in recipeRepository.searchRecipes(RecipeMock.searchName, 1)) {
//            println(recipe.toString())
//            assertEquals(
//                expected = "true",
//                actual = recipe.image,
//            )
//        }
//    }
//
//    @Test
//    fun delete_all_recipes_success() = runTest {
//        writeHead("delete_all_recipes_success")
//        assertTrue(recipeRepository.getAllRecipes().isNotEmpty())
//        recipeRepository.deleteAllRecipes()
//
//        assertTrue(
//            recipeRepository.getAllRecipes().isEmpty(),
//            "Delete All did not work"
//        )
//    }
//
//    @Test
//    fun delete_recipe_by_id_success() = runTest {
//        writeHead("delete_recipe_by_id_success")
//
//        recipeRepository.getAllRecipes().forEachIndexed { index, recipe ->
//
//            val recipeId = recipe.id
//            println("Delete recipe with ID: $recipeId")
//            recipeRepository.deleteRecipeById(recipeId)
//
//            assertEquals(
//                expected = recipeRepository.getAllRecipes().size,
//                actual = RecipeMock.recipeListDb.size - (index + 1),
//            )
//
//            assertNull(
//                recipeRepository.getRecipeById(recipeId)
//            )
//        }
//    }
//
//    @Test
//    fun insert_recipe_success() = runTest {
//        writeHead("insert_recipe_success")
//
//        for (recipe in recipeRepository.getAllRecipes()) {
//            println(recipe.toString())
//        }
//
//        recipeRepository.insertRecipe(RecipeMock.recipeDb)
//
//        for (recipe in recipeRepository.getAllRecipes()) {
//            println(recipe.toString())
//        }
//
//        assertEquals(
//            expected = recipeRepository.getAllRecipes().last(),
//            actual = RecipeMock.recipeDb,
//        )
//    }
//
//    @Test
//    fun update_recipe_success() = runTest {
//        writeHead("update_recipe_success")
//
//        for (recipe in recipeRepository.getAllRecipes()) {
//            println(recipe.toString())
//        }
//
//        val oldRecipe = recipeRepository.getAllRecipes()[2]
//
//        val newRecipe = RecipeDb(
//            id = oldRecipe.id,
//            name = "${oldRecipe.name}_new",
//            image = "${oldRecipe.image}_new",
//            cooking_time = oldRecipe.cooking_time + 1,
//            cooking_time_unit = "${oldRecipe.cooking_time_unit}_new",
//            description = "${oldRecipe.description}_new",
//        )
//
//        recipeRepository.updateRecipe(newRecipe)
//
//        for (recipe in recipeRepository.getAllRecipes()) {
//            println(recipe.toString())
//        }
//
//        assertEquals(
//            expected = newRecipe,
//            actual = recipeRepository.getRecipeById(oldRecipe.id),
//        )
//    }
//}
