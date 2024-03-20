package com.example.hydrationappcompose.domain.usecase

import com.example.hydrationappcompose.data.datasource.SettingsDataSource

class GetSettingsUseCase(private val dataSource: SettingsDataSource) {
    operator fun invoke() = dataSource.settingsFlow
}
