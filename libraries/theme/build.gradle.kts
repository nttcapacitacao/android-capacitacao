import dependencies.AndroidX
import dependencies.Google
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

    implementation(AndroidX.core_ktx)
    implementation(AndroidX.app_compat)
    implementation(AndroidX.constraint_layout)
    implementation(AndroidX.lifecycle_viewmodel)
    implementation(AndroidX.lifecycle_runtime)
    implementation(Google.googleAndroidMaterial)
    testImplementation(Testes.junit)
    androidTestImplementation(Testes.androidxTestJunit)
    androidTestImplementation(Testes.androidxEspresso)

    //Dagger
    implementation(Google.dagger_impl)
    kapt(Google.dagger_kpt)
    implementation(Google.dagger_android)
    kapt(Google.dagger_processor_kapt)
    annotationProcessor(Google.dagger_android_processor)
}