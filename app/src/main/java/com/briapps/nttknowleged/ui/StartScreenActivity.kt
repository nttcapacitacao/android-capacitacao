package com.briapps.nttknowleged.ui

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.briapps.core.base.BaseActivity
import com.briapps.nttknowleged.R
import kotlinx.coroutines.delay

class StartScreenActivity : BaseActivity(
    layoutActivityId = R.layout.start_activity
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initHome()
    }

    private fun initHome() {
        lifecycleScope.launchWhenCreated {
            delay(1000)

            // TODO start activity here
        }
    }
}