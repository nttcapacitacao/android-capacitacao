package com.briapps.core.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun String.getFormatDate(separator: String = " "): String {
    return try {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val formatter = SimpleDateFormat("dd/MM/yyyy - HH:mm", Locale("pt","BR"))
        formatter.timeZone = TimeZone.getTimeZone("GMT-3")
        parser.parse(this)?.let { formatter.format(it).replace("-", separator) } ?: this
    } catch (e: ParseException) {
        this
    }
}
