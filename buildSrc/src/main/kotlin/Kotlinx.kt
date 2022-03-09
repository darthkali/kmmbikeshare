object Kotlinx {
    private const val kotlinxDatetimeVersion = "0.1.1"
    const val coroutines = "1.5.0-native-mt"
    const val kotlinxSerialization = "1.2.1"

    const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${kotlinxDatetimeVersion}"
    const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutines}"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${coroutines}"
    const val serialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${kotlinxSerialization}"
}