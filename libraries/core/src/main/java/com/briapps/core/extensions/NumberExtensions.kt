package com.briapps.core.extensions

import com.briapps.core.util.Constants.NUMBER_ZERO

fun Int?.orDefault(default: Int = NUMBER_ZERO): Int = this ?: default

fun String.clearMonetary() = this.replace("[R$. \n]".toRegex(),"")
    .replace(",","")