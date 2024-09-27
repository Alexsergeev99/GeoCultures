package ru.alexsergeev.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.domain.usecase.interfaces.GetMedicationListUseCase
import ru.alexsergeev.presentation.mock.mockMedications
import ru.alexsergeev.presentation.models.MedicationUiModel
import ru.alexsergeev.presentation.utils.DomainMedicationListToUiMedicationListMapper

internal class MedicationViewModel(
    private val getMedicationListUseCase: GetMedicationListUseCase,
    private val domainMedicationListToUiMedicationListMapper: DomainMedicationListToUiMedicationListMapper
) : ViewModel() {

    private val _medications = MutableStateFlow<List<MedicationUiModel>>(emptyList())
    val medications: StateFlow<List<MedicationUiModel>> get() = _medications

    private val isLoadingMutable = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = isLoadingMutable

    init {
        getMedicationList()
    }

    private fun getMedicationList() {
        viewModelScope.launch {
            try {
                _medications.update {
                    domainMedicationListToUiMedicationListMapper.map(
                        getMedicationListUseCase.invoke().first()
                    )
                }
            } catch (e: Exception) {
                _medications.update {
                    domainMedicationListToUiMedicationListMapper.map(
                        mockMedications
                    )
                }
            }
        }
    }
}