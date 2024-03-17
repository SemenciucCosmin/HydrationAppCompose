package com.example.hydrationappcompose.presentation.ui.viewmodel.model

import com.example.hydrationappcompose.model.MeasurementUnit

data class UnitsUiState(
    val unitId: Int = MeasurementUnit.MILLILITERS.id,
    val isLoading: Boolean = true
)
