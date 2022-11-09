import dependencies.Google
import dependencies.Versions
import dependencies.Testes

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    compileSdk = 33
    defaultConfig {
        minSdk = 22
        targetSdk = 33

        testInstrumentationRunner = Testes.androidXTestRunner
        consumerProguardFiles("consumer-rules.pro")
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

    api(project(":libraries:core"))
    api(project(":libraries:theme"))

    //Dagger
    implementation(Google.dagger_impl)
    kapt(Google.dagger_kpt)
    implementation(Google.dagger_android)
    kapt(Google.dagger_processor_kapt)
    annotationProcessor("com.google.dagger:dagger-android-processor:2.38.1")
}