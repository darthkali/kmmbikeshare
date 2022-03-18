plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

android {
    compileSdk = Application.compileSdk
    defaultConfig {
        applicationId = Application.appId
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }

    packagingOptions {
        exclude("META-INF/*")
    }




}

dependencies {
    implementation(project(":shared"))
//    implementation("com.google.android.material:material:1.4.0")
//    implementation("androidx.appcompat:appcompat:1.3.1")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    implementation(Coil.compose)

    implementation(AndroidX.appCompat)
    implementation(AndroidX.fragmentKtx)

    implementation(Compose.runtime)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.activity)
    implementation(Compose.navigation)
    androidTestImplementation(Compose.test)
    debugImplementation(Compose.testManifest)

    implementation(Google.material)

    implementation(Kotlinx.datetime)

    implementation(Ktor.android)

    implementation(Koin.core)
    implementation(Koin.android)
    implementation(Koin.compose)
    implementation(Koin.test)
    implementation(Koin.testJunit4)

    debugImplementation(SquareUp.leakCanary)
}