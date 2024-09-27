package ru.alexsergeev.domain.usecase.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.domain.models.MedicationDomainModel
import ru.alexsergeev.domain.repository.MainRepository
import ru.alexsergeev.domain.usecase.interfaces.GetMedicationListUseCase

internal class GetMedicationListUseCaseImpl(private val repository: MainRepository) :
    GetMedicationListUseCase {
    override fun invoke(): Flow<List<MedicationDomainModel>> = repository.getMedicationList()
}