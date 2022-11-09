package com.briapps.core.extensions

import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import com.briapps.core.util.Constants
import java.util.regex.Pattern

fun String.removeAllDigits() = this.replace("\\D".toRegex(), Constants.EMPTY_STRING)