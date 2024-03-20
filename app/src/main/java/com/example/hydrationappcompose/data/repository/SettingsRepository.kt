package com.example.hydrationappcompose.data.repository

interface SettingsRepository {
    suspend fun saveUnitId(unitId: Int)

    suspend fun saveDailyGoal(dailyGoal: Int)

    suspend fun saveContainer1Size(size: Int)

    suspend fun saveContainer2Size(size: Int)

    suspend fun saveContainer3Size(size: Int)
}
