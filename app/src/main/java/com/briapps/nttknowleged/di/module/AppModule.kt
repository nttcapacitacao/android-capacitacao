package com.briapps.nttknowleged.di.module

import com.briapps.core.di.FeatureScope
import com.briapps.nttknowleged.ui.StartScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @FeatureScope
    @ContributesAndroidInjector
    abstract fun bindStartScreenActivity(): StartScreenActivity
}