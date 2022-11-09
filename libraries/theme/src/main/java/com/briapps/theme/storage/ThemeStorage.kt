package com.briapps.theme.storage

import android.content.Context
import androidx.annotation.StyleRes
import com.briapps.theme.R

class ThemeStorage(
    private val context: Context
) {

    private val sharedThemeKey = "theme_shared_key"
    private val sharedThemeValueKey = "theme_shared_value"

    fun getCurrentTheme() : Int {
        val currentThem = context.getSharedPreferences(sharedThemeKey, Context.MODE_PRIVATE)
        return currentThem.getInt(sharedThemeValueKey, R.style.Theme_NTTKnowleged)
    }

    fun setCurrentTheme(@StyleRes theme: Int) {
        val currentThem = context.getSharedPreferences(sharedThemeKey, Context.MODE_PRIVATE)
        currentThem.edit().putInt(sharedThemeValueKey, theme).apply()
    }
}