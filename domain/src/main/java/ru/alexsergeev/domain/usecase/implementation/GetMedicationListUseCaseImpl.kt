package ru.alexsergeev.domain.usecase.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.models.MedicationDomainModel
import ru.alexsergeev.domain.repository.MainRepository
import ru.alexsergeev.domain.usecase.interfaces.GetMedicationListUseCase
import ru.alexsergeev.domain.usecase.interfaces.GetMedicationUseCase

internal class GetMedicationListUseCaseImpl(private val repository: MainRepository) :
    GetMedicationListUseCase {
    override fun invoke(search: String): Flow<List<MedicationDomainModel>> = repository.getMedicationList(search)
}

internal class GetMedicationUseCaseImpl(private val repository: MainRepository) :
    GetMedicationUseCase {
    override fun invoke(id: Int): Flow<MedicationDomainModel> = repository.getMedication(id)
}