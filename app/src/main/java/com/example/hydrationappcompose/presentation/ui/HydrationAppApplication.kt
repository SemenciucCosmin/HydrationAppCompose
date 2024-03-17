package com.example.hydrationappcompose.presentation.ui

import android.app.Application
import com.example.hydrationappcompose.di.libraryModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HydrationAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@HydrationAppApplication)
            modules(libraryModules)
        }
    }
}
