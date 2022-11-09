package com.briapps.core.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.View
import android.widget.ImageView

fun ImageView.loadEncodedImage(base64: String, injectPropertiesView: (View.() -> Unit)? = null) =
    apply {
        injectPropertiesView?.invoke(this)
        convertBase64ToImage(base64)?.let { setImageBitmap(it) }
    }

fun convertBase64ToImage(encodedImage: String): Bitmap? {
    val decodedString: ByteArray = Base64.decode(encodedImage, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
}