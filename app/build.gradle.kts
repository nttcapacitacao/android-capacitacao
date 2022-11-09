import dependencies.Libraries
import dependencies.Versions
import dependencies.Google
import dependencies.AndroidX
import dependencies.Testes

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {

    compileSdk = 33
    defaultConfig {
        applicationId = Versions.applicationID
        minSdk = 22
        targetSdk = 33
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = Testes.androidXTestRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
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
    namespace = "com.briapps.nttknowleged"
    buildToolsVersion = "32.0.0"
}

dependencies {

    implementation(AndroidX.core_ktx)
    implementation(AndroidX.app_compat)
    implementation(AndroidX.constraint_layout)
    implementation(Google.googleAndroidMaterial)
    testImplementation(Testes.junit)
    androidTestImplementation(Testes.androidxTestJunit)
    androidTestImplementation(Testes.androidxEspresso)

    //Thyrd party libraries
    implementation(Libraries.lottieView)

    //JetPack
    implementation(Google.data_store)
    implementation(Google.room)
    kapt(Google.room_kapt)
    androidTestImplementation(Google.room_test)
    implementation(AndroidX.nav_fragment_ktx)
    implementation(AndroidX.nav_ui_ktx)
    implementation(AndroidX.nav_ui_ktx_test)

    //Dagger
    implementation(Google.dagger_impl)
    kapt(Google.dagger_kpt)
    implementation(Google.dagger_android)
    kapt(Google.dagger_processor_kapt)
    annotationProcessor(Google.dagger_android_processor)

    implementation(project(":libraries:core"))
    implementation(project(":libraries:di"))
    implementation(project(":libraries:theme"))
}