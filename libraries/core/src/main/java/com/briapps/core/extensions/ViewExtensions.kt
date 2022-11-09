package com.briapps.core.extensions

import android.os.SystemClock
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.briapps.core.R
import com.briapps.core.util.Constants.DELAYED_CLICK_TIME
import com.google.android.material.textfield.TextInputEditText

fun ImageView.loadSvgOrImageUrl(url: String) {
    val imageLoader = ImageLoader.Builder(context.applicationContext)
        .componentRegistry { add(SvgDecoder(context.applicationContext)) }
        .build()

    val request = ImageRequest.Builder(this.context)
        .diskCachePolicy(CachePolicy.ENABLED)
        .data(url)
        .target(this)
        .build()
    imageLoader.enqueue(request)
}

fun ImageView.loadSvgOrImageUrlWithError(
    url: String,
    @DrawableRes ErrorImage: Int
) {
    val imageLoader = ImageLoader.Builder(context.applicationContext)
        .componentRegistry { add(SvgDecoder(context.applicationContext)) }
        .build()

    val request = ImageRequest.Builder(this.context)
        .diskCachePolicy(CachePolicy.ENABLED)
        .data(url)
        .error(ErrorImage)
        .target(this)
        .build()
    imageLoader.enqueue(request)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.changeVisibilityFromBoolean(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun TextInputEditText.setErrorWithUnit(
    errorMessage: Int?,
    executeFun: () -> Unit?
) {
    apply {
        error = errorMessage?.let { this.context.getString(it) }
        executeFun.invoke()
        requestFocus()
    }
}

fun View.setOnClickListenerWithDelay(delay: Long = DELAYED_CLICK_TIME, listener: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickedTime: Long = 0
        override fun onClick(p0: View?) {
            if (SystemClock.elapsedRealtime() - lastClickedTime < delay) return
            else listener()
            lastClickedTime = SystemClock.elapsedRealtime()
        }
    })
}