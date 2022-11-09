import dependencies.Versions
import dependencies.AndroidX
import dependencies.Google
import dependencies.Testes
import dependencies.Libraries

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = 33
    defaultConfig {
        minSdk = 22
        targetSdk = 33

        testInstrumentationRunner = Testes.androidXTestRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    implementation(AndroidX.core_ktx)
    implementation(AndroidX.app_compat)
    implementation(AndroidX.constraint_layout)
    implementation(AndroidX.lifecycle_viewmodel)
    implementation(AndroidX.lifecycle_runtime)
    implementation(Google.googleAndroidMaterial)
    testImplementation(Testes.junit)
    androidTestImplementation(Testes.androidxTestJunit)
    androidTestImplementation(Testes.androidxEspresso)

    //Thyrd party libraries
    implementation(Libraries.lottieView)
    implementation(project(":libraries:core"))
    implementation(project(":libraries:theme"))
}