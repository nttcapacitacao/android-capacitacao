package com.briapps.di

import com.briapps.theme.di.ThemeProviders
import dagger.Module

@Module(
    includes = [
        ThemeProviders::class
    ]
)
class UnifiedFeatureModule