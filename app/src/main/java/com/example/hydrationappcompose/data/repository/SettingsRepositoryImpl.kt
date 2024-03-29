package com.example.hydrationappcompose.data.repository

import com.example.hydrationappcompose.data.datasource.SettingsDataSource

class SettingsRepositoryImpl(private val dataSource: SettingsDataSource) : SettingsRepository {
    override suspend fun saveUnitId(unitId: Int) = dataSource.saveUnitId(unitId)

    override suspend fun saveDailyGoal(dailyGoal: Float) = dataSource.saveDailyGoal(dailyGoal)

    override suspend fun saveContainer1Size(size: Float) = dataSource.saveContainer1Size(size)

    override suspend fun saveContainer2Size(size: Float) = dataSource.saveContainer2Size(size)

    override suspend fun saveContainer3Size(size: Float) = dataSource.saveContainer3Size(size)
}
