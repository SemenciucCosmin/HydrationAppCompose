package com.example.hydrationappcompose.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hydrationappcompose.domain.usecase.GetSettingsUseCase
import com.example.hydrationappcompose.presentation.ui.viewmodel.model.SettingsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(private val getSettingsUseCase: GetSettingsUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getSettingsUseCase().collectLatest { settings ->
                _uiState.update {
                    it.copy(
                        unitId = settings.unitId,
                        dailyGoal = settings.dailyGoal,
                        container1Size = settings.container1Size,
                        container2Size = settings.container2Size,
                        container3Size = settings.container3Size
                    )
                }
            }
        }
    }
}
