//package de.darthkali.weefood.datasource.database.repository.weekRecipe
//
//import de.darthkali.weefood.BaseTest
//import de.darthkali.weefood.mockFactory.WeekRecipeMock
//import de.darthkali.weefood.writeHead
//import org.koin.core.component.inject
//import kotlin.test.BeforeTest
//import kotlin.test.Test
//import kotlin.test.assertEquals
//import kotlin.test.assertTrue
//
//class WeekRecipeRepositoryImplTest : BaseTest() {
//
//    private val weekRecipeRepository: WeekRecipeRepository by inject()
//
//    @BeforeTest
//    fun setup() = runTest {
//        writeHead("setup")
//        weekRecipeRepository.deleteAllWeekRecipe()
//        val weekRecipes = WeekRecipeMock.weekRecipeDbList
//
//        for (weekRecipe in weekRecipes) {
//            weekRecipeRepository.insertWeekRecipe(weekRecipe)
//        }
//    }
//
//    @Test
//    fun get_all_week_recipes_success() = runTest {
//        writeHead("get_all_week_recipes_success")
//        val weekRecipes = weekRecipeRepository.getAllWeekRecipes()
//        weekRecipes.forEachIndexed { index, weekRecipe ->
//            println(weekRecipe.toString())
//
//            assertEquals(
//                expected = WeekRecipeMock.weekRecipeDbList[index],
//                actual = weekRecipe
//            )
//        }
//    }
//
//    @Test
//    fun get_all_week_recipe_by_weekday() = runTest {
//        writeHead("get_all_week_recipe_by_weekday")
//
//        val weekRecipes =
//            weekRecipeRepository.getAllWeekRecipesByWeekDay(WeekRecipeMock.weekDayForSearch)
//
//        for (weekRecipe in weekRecipes) {
//            println(weekRecipe.toString())
//            assertEquals(
//                expected = WeekRecipeMock.weekDayForSearch,
//                actual = weekRecipe.weekday,
//            )
//        }
//    }
//
//    @Test
//    fun delete_all_week_recipes_success() = runTest {
//        writeHead("delete_all_week_recipes_success")
//        assertTrue(weekRecipeRepository.getAllWeekRecipes().isNotEmpty())
//        weekRecipeRepository.deleteAllWeekRecipe()
//
//        assertTrue(
//            weekRecipeRepository.getAllWeekRecipes().isEmpty(),
//            "Delete All did not work"
//        )
//    }
//
//    @Test
//    fun delete_week_recipe_by_id_success() = runTest {
//        writeHead("delete_week_recipe_by_id_success")
//
//        weekRecipeRepository.getAllWeekRecipes().forEachIndexed { index, weekRecipe ->
//
//            val weekRecipeId = weekRecipe.id
//            println("Delete Ingredient with ID: $weekRecipeId")
//            weekRecipeRepository.deleteWeekRecipeById(weekRecipeId)
//
//            assertEquals(
//                expected = weekRecipeRepository.getAllWeekRecipes().size,
//                actual = WeekRecipeMock.weekRecipeDbList.size - (index + 1),
//            )
//        }
//        assertEquals(
//            expected = 0,
//            actual = weekRecipeRepository.getAllWeekRecipes().size,
//        )
//    }
//
//    @Test
//    fun insert_week_recipe_success() = runTest {
//        writeHead("insert_week_recipe_success")
//
//        for (weekRecipe in weekRecipeRepository.getAllWeekRecipes()) {
//            println(weekRecipe.toString())
//        }
//
//        weekRecipeRepository.insertWeekRecipe(WeekRecipeMock.weekRecipeDb)
//
//        for (weekRecipe in weekRecipeRepository.getAllWeekRecipes()) {
//            println(weekRecipe.toString())
//        }
//
//        assertEquals(
//            expected = weekRecipeRepository.getAllWeekRecipes().last(),
//            actual = WeekRecipeMock.weekRecipeDb,
//        )
//    }
//}
