package com.briapps.nttknowleged.di

import com.briapps.nttknowleged.di.module.AndroidModule
import com.briapps.di.UnifiedFeatureModule
import com.briapps.nttknowleged.MyShoppingApplication
import com.briapps.nttknowleged.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        AndroidModule::class,
        UnifiedFeatureModule::class
    ]
)
internal interface AppComponent: AndroidInjector<MyShoppingApplication> {
    @Component.Factory
    interface Factory: AndroidInjector.Factory<MyShoppingApplication>
}