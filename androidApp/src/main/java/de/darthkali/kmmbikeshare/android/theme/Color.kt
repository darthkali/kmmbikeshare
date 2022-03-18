package de.darthkali.kmmbikeshare.android.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

/* Primary Color */
val Primary = Color(0xFF22f4ae)
val Secondary = Color(0xFF00c9ec)
val Black = Color(0xFF000000)
val DarkGray = Color(0xFF292929)
val White = Color(0xFFffffff)


/* Secondary blue color */
val SecondaryBlue = Color(0xFF007286)
val SecondaryBlueTint10 = Color(0xFFffffff)

val DarkColors = darkColors(
    primary = Black,
    primaryVariant = DarkGray,
    secondary = DarkGray,
    background = DarkGray,
    surface = DarkGray,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
)

val LightColors = lightColors(
    primary = Primary,
    primaryVariant = Secondary,
    secondary = SecondaryBlue,
    background = White,
    surface = White,
    onPrimary = SecondaryBlueTint10,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black,
)
