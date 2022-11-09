package com.briapps.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.briapps.core.R
import com.briapps.core.extensions.setStatusBarColor
import com.briapps.core.util.AccessibilityComponent
import com.briapps.theme.AppThemeConfiguration

abstract class BaseBindActivity<T : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutActivityId: Int? = null,
    private val themeId: Int? = AppThemeConfiguration.themeId,
    private val hasDarkStatusBar: Boolean = false
) : AppCompatActivity(), AccessibilityComponent {

    protected lateinit var binding: T
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        themeId?.let { setAppTheme(it) }

        super.onCreate(savedInstanceState)
        layoutActivityId?.let { binding = DataBindingUtil.setContentView(this, it) }
        viewModel = ViewModelProvider(this).get(getViewModel())
    }

    protected fun setAppTheme(themeId: Int) {
        setTheme(themeId)
        if (hasDarkStatusBar)
            setStatusBarColor(com.briapps.theme.R.color.primary_color_dark)
    }

    abstract fun getViewModel(): Class<VM>

}