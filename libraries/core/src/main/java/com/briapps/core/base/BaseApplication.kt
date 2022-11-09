package com.briapps.core.base

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.briapps.theme.storage.ThemeStorage
import dagger.android.DaggerApplication

abstract class BaseApplication : DaggerApplication(), Application.ActivityLifecycleCallbacks {

    private val themProvider: ThemeStorage by lazy { ThemeStorage(this) }

    override fun onCreate() {
        super.onCreate()

        initFirebaseApp()
    }

    protected open fun initFirebaseApp() {
        //FirebaseApp.initializeApp(this)
    }

    fun returnThemeStorage() = themProvider

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit

    override fun onActivityStarted(activity: Activity) = Unit

    override fun onActivityResumed(activity: Activity) = Unit

    override fun onActivityPaused(activity: Activity) = Unit

    override fun onActivityStopped(activity: Activity) = Unit

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit

    override fun onActivityDestroyed(activity: Activity) = Unit
}