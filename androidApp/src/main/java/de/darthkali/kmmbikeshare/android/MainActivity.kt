package de.darthkali.kmmbikeshare.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import de.darthkali.kmmbikeshare.android.di.appModule
import de.darthkali.kmmbikeshare.android.navigation.Navigation
import de.darthkali.kmmbikeshare.di.initKoin
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }

        setContent {
            Navigation()
        }
    }
}
