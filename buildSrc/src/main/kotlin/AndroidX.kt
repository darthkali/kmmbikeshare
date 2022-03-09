object Versions {
    const val appCompatVersion = "1.3.0-rc01"
    const val fragmentKtxVersion = "1.3.3"
    const val test = "1.3.0"
    const val test_ext = "1.1.2"
}

object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
}

object AndroidXTest {
    const val core = "androidx.test:core-ktx:${Versions.test}"
    const val junit = "androidx.test.ext:junit:${Versions.test_ext}"
    const val runner = "androidx.test:runner:${Versions.test}"
    const val rules = "androidx.test:rules:${Versions.test}"
}