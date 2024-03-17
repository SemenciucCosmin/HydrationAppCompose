package com.example.hydrationappcompose.di

import com.example.hydrationappcompose.presentation.ui.viewmodel.HistoryViewModel
import com.example.hydrationappcompose.presentation.ui.viewmodel.SettingsViewModel
import com.example.hydrationappcompose.presentation.ui.viewmodel.TodayViewModel
import com.example.hydrationappcompose.presentation.ui.viewmodel.UnitsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::TodayViewModel)
    viewModelOf(::HistoryViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::UnitsViewModel)
}
