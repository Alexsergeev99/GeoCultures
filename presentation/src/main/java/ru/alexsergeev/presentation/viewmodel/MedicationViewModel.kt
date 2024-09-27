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
import ru.alexsergeev.domain.usecase.interfaces.GetMedicationUseCase
import ru.alexsergeev.presentation.mock.mockMedications
import ru.alexsergeev.presentation.models.MedicationUiModel
import ru.alexsergeev.presentation.utils.DomainMedicationListToUiMedicationListMapper
import ru.alexsergeev.presentation.utils.DomainMedicationToUiMedicationMapper
import java.io.IOException

internal class MedicationViewModel(
    private val getMedicationListUseCase: GetMedicationListUseCase,
    private val getMedicationUseCase: GetMedicationUseCase,
    private val domainMedicationToUiMedicationMapper: DomainMedicationToUiMedicationMapper,
    private val domainMedicationListToUiMedicationListMapper: DomainMedicationListToUiMedicationListMapper
) : ViewModel() {

    private val _medications = MutableStateFlow<List<MedicationUiModel>>(emptyList())
    val medications: StateFlow<List<MedicationUiModel>> get() = _medications

    private val _medication = MutableStateFlow<MedicationUiModel>(MedicationUiModel(1, "", "",""))
    private val medication: StateFlow<MedicationUiModel> get() = _medication

    private val isLoadingMutable = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = isLoadingMutable

    init {
        getMedicationList()
    }

    private fun getMedicationList() {
        viewModelScope.launch {
            try {
                getMedicationListUseCase.invoke()
                    .collect { medicationList ->
                        _medications.update {
                            domainMedicationListToUiMedicationListMapper.map(medicationList)
                        }
                    }
            } catch (e: IOException) {
                Log.e("test", "Network error: ${e.message}")
            } catch (e: Exception) {
                Log.e("test", "Unexpected error: ${e.message}")
            }
        }
    }

    fun getMedication(id: Int): MedicationUiModel {
        viewModelScope.launch {
            try {
                getMedicationUseCase.invoke(id)
                    .collect { medication ->
                        _medication.update {
                            domainMedicationToUiMedicationMapper.map(medication)
                        }
                    }
            } catch (e: IOException) {
                Log.e("test", "Network error: ${e.message}")
            } catch (e: Exception) {
                Log.e("test", "Unexpected error: ${e.message}")
            }
        }
        return medication.value
    }
}