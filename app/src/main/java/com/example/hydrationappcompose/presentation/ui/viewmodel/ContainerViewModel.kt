package com.example.hydrationappcompose.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hydrationappcompose.data.repository.SettingsRepository
import com.example.hydrationappcompose.domain.model.Container
import com.example.hydrationappcompose.domain.usecase.GetSettingsUseCase
import com.example.hydrationappcompose.presentation.ui.viewmodel.model.ContainerUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContainerViewModel(
    private val settingsRepository: SettingsRepository,
    private val getSettingsUseCase: GetSettingsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ContainerUiState())
    val uiState: StateFlow<ContainerUiState> = _uiState.asStateFlow()

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

    fun saveContainerSize(containerSize: Float, container: Container) {
        viewModelScope.launch {
            when (container) {
                Container.DAILY_GOAL -> settingsRepository.saveDailyGoal(containerSize)
                Container.CONTAINER_1 -> settingsRepository.saveContainer1Size(containerSize)
                Container.CONTAINER_2 -> settingsRepository.saveContainer2Size(containerSize)
                Container.CONTAINER_3 -> settingsRepository.saveContainer3Size(containerSize)
            }
        }
    }
}
