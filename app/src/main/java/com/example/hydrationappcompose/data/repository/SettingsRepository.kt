package com.example.hydrationappcompose.data.repository

interface SettingsRepository {
    suspend fun saveUnitId(unitId: Int)

    suspend fun saveDailyGoal(dailyGoal: Float)

    suspend fun saveContainer1Size(size: Float)

    suspend fun saveContainer2Size(size: Float)

    suspend fun saveContainer3Size(size: Float)
}
