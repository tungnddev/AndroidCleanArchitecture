package com.greaper.data.di.module

import android.content.Context
import com.google.gson.Gson
import com.greaper.data.local.pref.AppPrefs
import com.greaper.data.local.pref.PrefHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PrefModule {
    @Provides
    @Singleton
    fun providePrefHelper(appPrefs: AppPrefs): PrefHelper {
        return appPrefs
    }

    @Provides
    @Singleton
    fun providerAppPrefs(@ApplicationContext context: Context): AppPrefs {
        return AppPrefs(context)
    }
}