import dependencies.Versions
import dependencies.Testes

plugins {
    id("com.android.library")
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
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}