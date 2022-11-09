package com.briapps.nttknowleged

import com.briapps.core.base.BaseApplication
import com.briapps.nttknowleged.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyShoppingApplication : BaseApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)
}