plugins {
    kotlin(KotlinPlugins.multiplatform)
    kotlin(KotlinPlugins.cocoapods)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(Plugins.androidLibrary)
    id(Plugins.sqlDelight)
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        // Common ----------
        val commonMain by getting{
            dependencies {
                implementation(Ktor.core)
                implementation(Ktor.clientSerialization)
                implementation(Kotlin.annotations)
                implementation(Kotlinx.datetime)
                implementation(Kotlinx.common)
                implementation(Kotlinx.serialization)
                implementation(SQLDelight.runtime)
                implementation(Koin.core)
                implementation(Koin.test)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Kotlin.commonTest)
                implementation(Kotlin.annotations)
                implementation(Koin.test)
            }
        }

        // Android ----------
        val androidMain by getting{
            dependencies {
                implementation(Ktor.android)
                implementation(SQLDelight.androidDriver)
                implementation(Kotlinx.android)
                implementation(Koin.test)
                implementation(Koin.testJunit4)
            }
        }

        val androidTest by getting {
            dependencies {
                implementation(Kotlin.jvm)
                implementation(Kotlin.junit)
                implementation(Ktor.android)
                implementation(SQLDelight.androidDriver)
                implementation(AndroidXTest.core)
                implementation(AndroidXTest.junit)
                implementation(AndroidXTest.runner)
                implementation(AndroidXTest.rules)
                implementation(Kotlinx.test)
                implementation(Robolectric.robolectric)
                implementation(Koin.android)
            }
        }


        // iOS ----------
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(Ktor.ios)
                implementation(SQLDelight.nativeDriver)
                implementation(Koin.core)
                implementation(Koin.test)
                implementation(Kotlinx.common) {
                    version {
                        strictly(Kotlinx.coroutines)
                    }
                }
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = Application.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }




}

sqldelight {
    database("KmmBikeShareDatabase") {
        packageName = "de.darthkali.kmm_bike_share.datasource.database"
        sourceFolders = listOf("sqldelight")
    }
}