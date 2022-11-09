package com.briapps.nttknowleged.di.module

import android.app.Application
import android.content.Context
import com.briapps.core.provider.DefaultDispatcherProvider
import com.briapps.nttknowleged.MyShoppingApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AndroidModule {

    @Provides
    @Singleton
    fun provideContext(application: MyShoppingApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun providesApplication(application: MyShoppingApplication): Application = application

    @Provides
    @Singleton
    fun provideDefaultDispatchers() =
        DefaultDispatcherProvider()
}