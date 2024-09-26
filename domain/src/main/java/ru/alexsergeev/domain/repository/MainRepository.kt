package ru.alexsergeev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.models.MedicationDomainModel

interface MainRepository {
    fun getMedicationList(): Flow<List<MedicationDomainModel>>
    fun getMedication(id: String): Flow<MedicationDomainModel>
}