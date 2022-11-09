import dependencies.AndroidX
import dependencies.Google
import dependencies.Libraries
import dependencies.Testes
import dependencies.Versions
import dependencies.Square

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
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

    dataBinding.isEnabled = true

    namespace = "com.briapps.core"
}

dependencies {

    implementation(AndroidX.core_ktx)
    implementation(AndroidX.app_compat)
    implementation(Google.googleAndroidMaterial)

    testImplementation(Testes.junit)

    androidTestImplementation(AndroidX.test_junit)
    androidTestImplementation(AndroidX.espresso)

    //Firebase
    implementation("com.google.firebase:firebase-firestore")

    //Retrofit
    implementation(Square.retrofit)
    implementation(Square.retrofit_gson)
    implementation(Square.okHttp)
    implementation(Square.okHttp_logging_interceptor)

    // Import the BoM for the Firebase platform
    implementation(platform(Google.firebase_bom))
    implementation(Google.firebase_auth)

    //JetPack
    implementation(Google.data_store)
    implementation(Google.room)
    kapt(Google.room_kapt)
    androidTestImplementation(Google.room_test)

    //Dagger
    implementation(Google.dagger_impl)
    kapt(Google.dagger_kpt)
    implementation(Google.dagger_android)
    kapt(Google.dagger_processor_kapt)
    annotationProcessor(Google.dagger_android_processor)

    implementation(Libraries.coil_image_loader)
    implementation(Libraries.coil_image_svg)
    implementation(project(":libraries:theme"))
}