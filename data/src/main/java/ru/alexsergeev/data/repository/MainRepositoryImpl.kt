package ru.alexsergeev.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.data.api.ApiService
import ru.alexsergeev.data.errors.ApiError
import ru.alexsergeev.data.errors.UnknownError
import ru.alexsergeev.data.utils.ListResponseListToMedicationDomainModelListMapper
import ru.alexsergeev.data.utils.ListResponseToMedicationDomainModelMapper
import ru.alexsergeev.domain.models.MedicationDomainModel
import ru.alexsergeev.domain.repository.MainRepository
import java.io.IOException

internal class MainRepositoryImpl(
    private val apiService: ApiService,
    private val listMapper: ListResponseListToMedicationDomainModelListMapper,
    private val domainModelMapper: ListResponseToMedicationDomainModelMapper
) : MainRepository {

    override fun getMedicationList(): Flow<List<MedicationDomainModel>> = flow {
        try {
            val response = apiService.getAll(
                search = " ",
            )
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val body = response.body()
            if (body == null) {
                Log.e("error", "Response body is null")
                emit(emptyList())
            } else {
                emit(listMapper.map(body))
            }
        } catch (e: IOException) {
            Log.e("error", "Network error: ${e.message}", e)
            emit(emptyList())
        } catch (e: Exception) {
            Log.e("error", "Unexpected error: ${e.message}", e)
            emit(emptyList())
        }
    }

    override fun getMedication(id: Int): Flow<MedicationDomainModel> = flow {
        try {
            val response = apiService.getMedicationById(id)

            if (response.isSuccessful) {
                response.body()?.let { body ->
                    Log.d("res", body.toString())
                    emit(domainModelMapper.map(body))
                } ?: throw Exception("Response body is null")
            } else {
                throw ApiError(response.code(), response.message())
            }
        } catch (e: IOException) {
            Log.e("error", "Network error: ${e.message}")
            throw e
        } catch (e: Exception) {
            Log.e("error", "Unknown error: ${e.message}")
            throw e
        }
    }
}