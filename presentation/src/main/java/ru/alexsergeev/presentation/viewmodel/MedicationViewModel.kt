package ru.alexsergeev.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.presentation.models.MedicationUiModel

internal class MedicationViewModel : ViewModel() {

    private val _medications = MutableStateFlow<List<MedicationUiModel>>(emptyList())
    val medications: StateFlow<List<MedicationUiModel>> get() = _medications

    private val isLoadingMutable = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = isLoadingMutable

    init {
        viewModelScope.launch {
            getMedicationList()
        }
    }

    private fun getMedicationList() {
        Log.d("test", medications.value.toString())
        _medications.update {
            listOf(
                MedicationUiModel(1, "", "Медикамент 1", "Описание 1"),
                MedicationUiModel(2, "", "Медикамент 2", "Описание 2"),
                MedicationUiModel(3, "", "Медикамент 3", "Описание 3"),
                MedicationUiModel(4, "", "Медикамент 4", "Описание 4"),
                MedicationUiModel(5, "", "Медикамент 5", "Описание 5")
            )
        }
        Log.d("test1", medications.value.toString())
    }
}