package com.briapps.core.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.briapps.core.R
import com.briapps.core.extensions.setStatusBarColor
import com.briapps.core.util.AccessibilityComponent
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity(
    @LayoutRes private val layoutActivityId: Int? = null,
    private val hasDarkStatusBar: Boolean = false,
    private val injectDependencies: Boolean = false
) : DaggerAppCompatActivity(), AccessibilityComponent {

    private val rootView: ViewGroup by lazy { findViewById(android.R.id.content) }

    //private var userIsLogged: Boolean = false

    //private lateinit var firebaseAuth: FirebaseAuth
    //private var userName: String? = ""
    //private var firebaseUser: FirebaseUser? = null

    override var onAccessibilityEventListener: AccessibilityComponent.OnAccessibilityEventListener? =
        null
        set(value) {
            value?.let { registerAccessibilityListener(rootView, value) }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        /*firebaseAuth = FirebaseAuth.getInstance()
        firebaseUser = firebaseAuth.currentUser
        firebaseUser?.let { firebaseUser ->
            userName = firebaseUser.displayName.takeIf { it?.isEmpty() == true }
                ?.let { firebaseUser.email }
            userIsLogged = true
        }*/

        setAppTheme(
            (applicationContext as BaseApplication).returnThemeStorage().getCurrentTheme()
        )
        //themeId?.let { setAppTheme(it) }

        if (injectDependencies) {
            AndroidInjection.inject(this)
        }

        super.onCreate(savedInstanceState)
        layoutActivityId?.let { setContentView(it) }
    }

    private fun setAppTheme(themeId: Int) {
        setTheme(themeId)
        if (hasDarkStatusBar)
            setStatusBarColor(R.color.primary_color_dark)
    }
}