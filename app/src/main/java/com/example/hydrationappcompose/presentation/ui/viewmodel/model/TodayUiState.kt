package com.example.hydrationappcompose.presentation.ui.viewmodel.model

data class TodayUiState(
    val intake: Int = 0,
    val intakePercentage: Int = 0,
    val unitId: Int = 0,
    val dailyGoal: Int = 2000,
    val container1Size: Int = 100,
    val container2Size: Int = 250,
    val container3Size: Int = 750,
    val isLoading: Boolean = true
)
