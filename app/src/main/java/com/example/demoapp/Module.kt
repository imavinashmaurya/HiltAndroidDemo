package com.example.demoapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Singleton
    @Provides
    fun getIndianFood(): IndianFood {
        return IndianFood()
    }

    @Provides
    fun getChineseFood(): ChineseFood {
        return ChineseFood()
    }
}