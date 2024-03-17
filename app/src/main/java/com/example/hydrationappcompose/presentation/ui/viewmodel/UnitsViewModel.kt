package com.example.hydrationappcompose.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hydrationappcompose.presentation.ui.viewmodel.model.UnitsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UnitsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UnitsUiState())
    val uiState: StateFlow<UnitsUiState> = _uiState.asStateFlow()

    fun onSelectUnit(unitId: Int) {
        _uiState.update { it.copy(unitId = unitId) }
    }
}
