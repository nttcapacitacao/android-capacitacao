package dependencies

object AndroidX {
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val ui_tooling = "androidx.ui:ui-tooling:${Versions.androidx_ui}"

    // fragment ktx
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
    // navigation
    const val nav_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_component}"
    const val nav_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.nav_component}"
    const val nav_ui_ktx_test = "androidx.navigation:navigation-testing:${Versions.nav_component}"
    // navigation compose
    const val navigation_compose = "androidx.navigation:navigation-compose:${Versions.nav_compose}"

    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val compose_foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val compose_material = "androidx.compose.material:material:${Versions.compose}"
    const val compose_icons_core = "androidx.compose.material:material-icons-core:${Versions.compose}"

    const val compose_icons_extended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val constraint_compose = "androidx.constraintlayout:constraintlayout-compose:${Versions.compose_constraint}"
    const val compose_activity = "androidx.activity:activity-compose:${Versions.compose_activity}"
    const val navigation_hilt = "androidx.hilt:hilt-navigation:${Versions.hilt_navigation}"

    const val datastore = "androidx.datastore:datastore-preferences:${Versions.datastore}"

    const val test_junit =  "androidx.test.ext:junit:1.1.3"
    const val espresso = "androidx.test.espresso:espresso-core:3.4.0"

    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
}