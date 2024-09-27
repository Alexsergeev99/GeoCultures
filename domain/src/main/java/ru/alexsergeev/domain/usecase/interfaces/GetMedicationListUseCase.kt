package ru.alexsergeev.domain.usecase.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.models.MedicationDomainModel

interface GetMedicationListUseCase {
    operator fun invoke(): Flow<List<MedicationDomainModel>>
}