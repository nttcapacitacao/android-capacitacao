package dependencies

object Google {

    const val palette = "com.android.support:palette-v7:${Versions.palette}"
    const val googleAndroidMaterial = "com.google.android.material:material:${Versions.material}"
    const val gson = "com.google.code.gson:gson:${Versions.gSonVersion}"

    const val firebase_bom = "com.google.firebase:firebase-bom:${Versions.firebase_bom}"
    const val firebase_auth = "com.google.firebase:firebase-auth-ktx"
    const val firebase_cloud_message = "com.google.firebase:firebase-messaging"
    const val firebase_analytics = "com.google.firebase:firebase-analytics"

    /*JetPack*/
    const val data_store = "androidx.datastore:datastore-preferences:${Versions.data_store}"
    const val room_kapt = "androidx.room:room-compiler:${Versions.room}"
    const val room = "androidx.room:room-ktx:${Versions.room}"
    const val room_test = "androidx.room:room-testing:${Versions.room}"

    /*Hilt*/


    const val kapt_dagger_hilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android}"
    const val google_dagger = "com.google.dagger:dagger:${Versions.hilt_android}"
    const val kapt_google_dagger = "com.google.dagger:dagger-compiler:${Versions.hilt_android}"
    const val api_dagger_android = "com.google.dagger:dagger-android:${Versions.hilt_android}"
    const val api_dagger_android_support = "com.google.dagger:dagger-android:${Versions.hilt_android}"
    const val kapt_dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.hilt_android}"
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android}"

    const val dagger_impl = "com.google.dagger:dagger:${Versions.dagger_version}"
    const val dagger_kpt = "com.google.dagger:dagger-compiler:${Versions.dagger_version}"
    const val dagger_processor_kapt = "com.google.dagger:dagger-android-processor:${Versions.dagger_version}"
    const val dagger_android = "com.google.dagger:dagger-android-support:${Versions.dagger_version}"
    const val dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger_version}"
}