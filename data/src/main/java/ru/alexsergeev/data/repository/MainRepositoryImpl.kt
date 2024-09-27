package ru.alexsergeev.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.data.api.ApiService
import ru.alexsergeev.data.errors.ApiError
import ru.alexsergeev.data.errors.UnknownError
import ru.alexsergeev.data.utils.ListResponseListToMedicationDomainModelListMapper
import ru.alexsergeev.domain.models.MedicationDomainModel
import ru.alexsergeev.domain.repository.MainRepository
import java.io.IOException

internal class MainRepositoryImpl(
    private val apiService: ApiService,
    private val listMapper: ListResponseListToMedicationDomainModelListMapper
) : MainRepository {

    override fun getMedicationList(): Flow<List<MedicationDomainModel>> = flow {
        try {
            val response = apiService.getAll(
                id = 1,
                cropId = 1,
                harmfulObjectId = 1,
                ingredientId = 1,
                limit = 20,
                offset = 1,
            )
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            emit(listMapper.map(response.body() ?: emptyList()))
        } catch (e: IOException) {
            Log.d("error", "networkError")
        } catch (e: Exception) {
            throw UnknownError
        }
    }

    override fun getMedication(id: String): Flow<MedicationDomainModel> {
        TODO("Not yet implemented")
    }
}