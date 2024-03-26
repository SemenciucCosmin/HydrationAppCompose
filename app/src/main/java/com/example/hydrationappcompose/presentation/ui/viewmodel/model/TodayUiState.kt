package com.example.hydrationappcompose.presentation.ui.viewmodel.model

import com.example.hydrationappcompose.common.Defaults

data class TodayUiState(
    val intake: Float = Defaults.INTAKE,
    val intakePercentage: Float = Defaults.INTAKE_PERCENTAGE,
    val unitId: Int = Defaults.UNIT_ID,
    val dailyGoal: Float = Defaults.DAILY_GOAL,
    val container1Size: Float = Defaults.CONTAINER_1_SIZE,
    val container2Size: Float = Defaults.CONTAINER_2_SIZE,
    val container3Size: Float = Defaults.CONTAINER_3_SIZE,
    val isLoading: Boolean = true
)
