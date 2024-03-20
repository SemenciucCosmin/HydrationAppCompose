package com.example.hydrationappcompose.di

import com.example.hydrationappcompose.data.datasource.SettingsDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { SettingsDataSource(androidContext()) }
}
