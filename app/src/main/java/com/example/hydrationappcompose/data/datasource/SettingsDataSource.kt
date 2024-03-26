package com.example.hydrationappcompose.data.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.hydrationappcompose.common.Defaults
import com.example.hydrationappcompose.domain.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class SettingsDataSource(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = SHARED_PREFERENCES_NAME
    )

    val settingsFlow: Flow<Settings> = context.dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            val unitId = preferences[UNIT_KEY] ?: Defaults.UNIT_ID
            val dailyGoal = preferences[DAILY_GOAL_KEY] ?: Defaults.DAILY_GOAL
            val container1Size = preferences[CONTAINER_1_KEY] ?: Defaults.CONTAINER_1_SIZE
            val container2Size = preferences[CONTAINER_2_KEY] ?: Defaults.CONTAINER_2_SIZE
            val container3Size = preferences[CONTAINER_3_KEY] ?: Defaults.CONTAINER_3_SIZE

            Settings(
                unitId = unitId,
                dailyGoal = dailyGoal,
                container1Size = container1Size,
                container2Size = container2Size,
                container3Size = container3Size
            )
        }

    suspend fun saveUnitId(unitId: Int) {
        context.dataStore.edit { it[UNIT_KEY] = unitId }
    }

    suspend fun saveDailyGoal(dailyGoal: Float) {
        context.dataStore.edit { preferences -> preferences[DAILY_GOAL_KEY] = dailyGoal }
    }

    suspend fun saveContainer1Size(size: Float) {
        context.dataStore.edit { preferences -> preferences[CONTAINER_1_KEY] = size }
    }

    suspend fun saveContainer2Size(size: Float) {
        context.dataStore.edit { preferences -> preferences[CONTAINER_2_KEY] = size }
    }

    suspend fun saveContainer3Size(size: Float) {
        context.dataStore.edit { preferences -> preferences[CONTAINER_3_KEY] = size }
    }

    companion object {
        private const val SHARED_PREFERENCES_NAME = "hydration_app_shared_preferences"
        private val UNIT_KEY = intPreferencesKey("unit")
        private val DAILY_GOAL_KEY = floatPreferencesKey("daily_goal")
        private val CONTAINER_1_KEY = floatPreferencesKey("container_1")
        private val CONTAINER_2_KEY = floatPreferencesKey("container_2")
        private val CONTAINER_3_KEY = floatPreferencesKey("container_3")
    }
}
