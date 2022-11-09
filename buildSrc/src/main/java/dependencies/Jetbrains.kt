package dependencies

import dependencies.Versions.coroutines_version

object Jetbrains {

    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
}