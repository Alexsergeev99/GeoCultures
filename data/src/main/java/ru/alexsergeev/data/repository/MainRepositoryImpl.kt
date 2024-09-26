package ru.alexsergeev.data.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.data.api.ApiService
import ru.alexsergeev.domain.models.MedicationDomainModel
import ru.alexsergeev.domain.repository.MainRepository

internal class MainRepositoryImpl(
    private val apiService: ApiService,
) : MainRepository {

    override fun getMedicationList(): Flow<List<MedicationDomainModel>> {
        TODO("Not yet implemented")
    }

    override fun getMedication(id: String): Flow<MedicationDomainModel> {
        TODO("Not yet implemented")
    }
}