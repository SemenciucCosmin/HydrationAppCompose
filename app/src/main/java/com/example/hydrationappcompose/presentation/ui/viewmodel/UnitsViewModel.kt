package com.example.hydrationappcompose.presentation.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hydrationappcompose.common.Defaults
import com.example.hydrationappcompose.data.repository.SettingsRepository
import com.example.hydrationappcompose.domain.usecase.GetSettingsUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UnitsViewModel(
    private val settingsRepository: SettingsRepository,
    private val getSettingsUseCase: GetSettingsUseCase
) : ViewModel() {

    var unitId by mutableIntStateOf(Defaults.UNIT_ID)
        private set

    init {
        viewModelScope.launch {
            getSettingsUseCase().collectLatest { settings ->
                unitId = settings.unitId
            }
        }
    }

    fun selectUnit(unitId: Int) {
        viewModelScope.launch { settingsRepository.saveUnitId(unitId) }
    }
}
