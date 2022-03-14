//package de.darthkali.weefood.datasource.database.repository.recipeIngredient
//
//import de.darthkali.weefood.BaseTest
//import de.darthkali.weefood.mockFactory.RecipeIngredientMock
//import de.darthkali.weefood.writeHead
//import org.koin.core.component.inject
//import kotlin.test.BeforeTest
//import kotlin.test.Test
//import kotlin.test.assertEquals
//import kotlin.test.assertTrue
//
//class RecipeIngredientRepositoryImplTest : BaseTest() {
//
//    private val recipeIngredientRepository: RecipeIngredientRepository by inject()
//
//    @BeforeTest
//    fun setup() = runTest {
//        writeHead("setup")
//        recipeIngredientRepository.deleteAllRecipeIngredients()
//        val recipeIngredients = RecipeIngredientMock.recipeIngredientDbList
//
//        for (recipeIngredient in recipeIngredients) {
//            recipeIngredientRepository.insertRecipeIngredient(recipeIngredient)
//        }
//    }
//
//    @Test
//    fun get_all_recipe_ingredients_success() = runTest {
//        writeHead("get_all_recipe_ingredients_success")
//        val recipeIngredients = recipeIngredientRepository.getAllRecipeIngredients()
//        recipeIngredients.forEachIndexed { index, recipeIngredient ->
//            println(recipeIngredient.toString())
//            assertEquals(
//                RecipeIngredientMock.recipeIngredientDbList[index].recipe_id,
//                recipeIngredient.recipe_id
//            )
//        }
//    }
//
//    @Test
//    fun get_all_recipe_ingredient_by_recipe_id_success() = runTest {
//        writeHead("get_all_recipe_ingredient_by_recipe_id_success")
//
//        RecipeIngredientMock.recipeIngredientDbList.forEachIndexed { index, recipeMock ->
//            for (
//                recipeIngredient in recipeIngredientRepository.getAllRecipeIngredientByRecipeId(
//                    recipeMock.recipe_id
//                )
//            ) {
//                println(recipeIngredient.toString())
//                assertEquals(
//                    RecipeIngredientMock.recipeIngredientDbList[index].recipe_id,
//                    recipeIngredient.recipe_id,
//                )
//            }
//        }
//    }
//
//    @Test
//    fun delete_all_recipe_ingredients_success() = runTest {
//        writeHead("delete_all_recipe_ingredients_success")
//        assertTrue(recipeIngredientRepository.getAllRecipeIngredients().isNotEmpty())
//        recipeIngredientRepository.deleteAllRecipeIngredients()
//
//        assertTrue(
//            recipeIngredientRepository.getAllRecipeIngredients().isEmpty(),
//            "Delete All did not work"
//        )
//    }
//
//    @Test
//    fun delete_recipe_ingredient_by_id_success() = runTest {
//        writeHead("delete_recipe_ingredient_by_id_success")
//
//        recipeIngredientRepository.getAllRecipeIngredients()
//            .forEachIndexed { index, recipeIngredient ->
//
//                val recipeIngredientId = recipeIngredient.id
//                println("Delete recipeIngredient with ID: $recipeIngredientId")
//                recipeIngredientRepository.deleteRecipeIngredientById(recipeIngredientId)
//
//                assertEquals(
//                    expected = recipeIngredientRepository.getAllRecipeIngredients().size,
//                    actual = RecipeIngredientMock.recipeIngredientDbList.size - (index + 1),
//                )
//            }
//        assertEquals(
//            expected = 0,
//            actual = recipeIngredientRepository.getAllRecipeIngredients().size,
//        )
//    }
//
//    @Test
//    fun insert_recipe_ingredient_success() = runTest {
//        writeHead("insert_recipe_ingredient_success")
//
//        for (recipeIngredient in recipeIngredientRepository.getAllRecipeIngredients()) {
//            println(recipeIngredient.toString())
//        }
//
//        recipeIngredientRepository.insertRecipeIngredient(RecipeIngredientMock.recipeIngredientDb)
//
//        for (recipeIngredient in recipeIngredientRepository.getAllRecipeIngredients()) {
//            println(recipeIngredient.toString())
//        }
//
//        assertEquals(
//            expected = recipeIngredientRepository.getAllRecipeIngredients().last(),
//            actual = RecipeIngredientMock.recipeIngredientDb,
//        )
//    }
//
//    @Test
//    fun update_recipe_ingredient_success() = runTest {
//        writeHead("update_recipe_ingredient_success")
//
//        for (recipeIngredient in recipeIngredientRepository.getAllRecipeIngredients()) {
//            println(recipeIngredient.toString())
//        }
//
//        recipeIngredientRepository.updateRecipeIngredient(RecipeIngredientMock.recipeIngredientDbUpdate)
//
//        for (recipe in recipeIngredientRepository.getAllRecipeIngredients()) {
//            println(recipe.toString())
//        }
//        assertEquals(
//            expected = recipeIngredientRepository.getAllRecipeIngredients()[RecipeIngredientMock.recipeIngredientDbUpdateIndex],
//            actual = RecipeIngredientMock.recipeIngredientDbUpdate,
//        )
//    }
//
//    @Test
//    fun delete_recipe_ingredient_by_recipeId_success() = runTest {
//        writeHead("delete_recipe_ingredient_by_recipeId_success")
//
//        for (recipeIngredient in recipeIngredientRepository.getAllRecipeIngredients()) {
//            println(recipeIngredient.toString())
//        }
//
//        recipeIngredientRepository.deleteAllRecipeIngredientsByRecipeId(RecipeIngredientMock.deleteRecipeIngredientByRecipeId)
//
//        for (recipeIngredient in recipeIngredientRepository.getAllRecipeIngredients()) {
//            println(recipeIngredient.toString())
//        }
//
//        assertEquals(
//            expected = listOf(),
//            actual = recipeIngredientRepository.getAllRecipeIngredientByRecipeId(
//                RecipeIngredientMock.deleteRecipeIngredientByRecipeId
//            )
//        )
//    }
//}
