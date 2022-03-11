package de.darthkali.kmm_bike_share.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import de.darthkali.kmm_bike_share.di.initKoin
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi

//fun greet(): String {
//    return Greeting().greeting()
//}

class MainActivity : ComponentActivity() {

    private val searchIngredient: BicycleSharingSystemService by inject()
    val itemList = (0..50).toList()
//    val itemLists: List<BicycleSharingSystemNetworkObject> = listOf()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin {
            androidContext(this@MainActivity)
//            modules(appModule)
        }


        setContent {

            runBlocking {
                val result = searchIngredient.searchBicycleSharingSystems()

            }

            ItemList(itemList)
            testFetchNetwork()
//            val itemLists: List<BicycleSharingSystemNetworkObject> = searchIngredient.searchBicycleSharingSystems()

            ItemList(itemList)
        }
    }

    fun testFetchNetwork() = runBlocking {
        val result = searchIngredient.searchBicycleSharingSystems()
        println(result)
    }

    @Composable
    fun ItemList(items: List<Int>) {
        LazyColumn {
            items(items) {
                Text("Item is $it")
            }
        }
    }
//
//    private fun loadIngredients() {
//        searchIngredient.execute(
//        ).collectCommon(null) { dataState ->
//            itemLists.value = state.value.copy(isLoading = dataState.isLoading)
//
//            dataState.data?.let { ingredients ->
//                appendIngredients(ingredients)
//            }
//        }
//    }
}
