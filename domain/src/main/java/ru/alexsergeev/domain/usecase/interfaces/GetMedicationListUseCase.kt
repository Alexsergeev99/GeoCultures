package ru.alexsergeev.domain.usecase.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.models.MedicationDomainModel

interface GetMedicationListUseCase {
    operator fun invoke(search: String): Flow<List<MedicationDomainModel>>
}

interface GetMedicationUseCase {
    operator fun invoke(id: Int): Flow<MedicationDomainModel>
}