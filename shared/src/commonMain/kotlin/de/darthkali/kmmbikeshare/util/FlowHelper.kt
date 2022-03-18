package de.darthkali.kmmbikeshare.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Source:
 * https://stackoverflow.com/questions/64175099/listen-to-kotlin-coroutine-flow-from-ios
 * and from Mitch Tabian
 */

/**
 * Must create a (class + function) since extension functions can't be used on iOS with KMM.
 * Otherwise I'd simply create a Flow<T>.collectCommon() function.
 */
fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)

class CommonFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {
    fun collectCommon(
        coroutineScope: CoroutineScope? = null, // 'viewModelScope' on Android and 'nil' on iOS
        callback: (T) -> Unit, // callback on each emission
    ) {
        onEach {
            callback(it)
        }.launchIn(coroutineScope ?: CoroutineScope(Dispatchers.Main))
    }
}
