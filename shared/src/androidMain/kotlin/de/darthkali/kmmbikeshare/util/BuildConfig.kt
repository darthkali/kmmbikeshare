package de.darthkali.kmmbikeshare.util

import de.darthkali.kmmbikeshare.BuildConfig


actual class BuildConfig {
    actual fun isDebug() = BuildConfig.DEBUG
    actual fun isAndroid() = true
}
