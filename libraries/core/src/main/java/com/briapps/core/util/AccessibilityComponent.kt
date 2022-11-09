package com.briapps.core.util

import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent

interface AccessibilityComponent {

    var onAccessibilityEventListener: OnAccessibilityEventListener?

    fun registerAccessibilityListener(host: View, listener: OnAccessibilityEventListener) {

        host.accessibilityDelegate = object : View.AccessibilityDelegate() {
            override fun onRequestSendAccessibilityEvent(
                host: ViewGroup,
                child: View,
                event: AccessibilityEvent
            ): Boolean {
                listener.onRequestSendAccessibilityEvent(event)
                return super.onRequestSendAccessibilityEvent(host, child, event)
            }
        }

    }

    interface OnAccessibilityEventListener {
        fun onRequestSendAccessibilityEvent(event: AccessibilityEvent)
    }
}