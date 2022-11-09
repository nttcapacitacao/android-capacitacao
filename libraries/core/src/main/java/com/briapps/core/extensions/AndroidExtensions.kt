package com.briapps.core.extensions

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Activity.setStatusBarColor(@ColorRes colorId: Int) {
    val window = window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = getResColor(colorId)
}

fun Context.getResColor(@ColorRes idColor: Int) = ContextCompat.getColor(this, idColor)