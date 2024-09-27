package ru.alexsergeev.data.utils

import ru.alexsergeev.data.models.ListResponse
import ru.alexsergeev.domain.models.MedicationDomainModel

internal interface Mapper<in I, out O> {
    fun map(input: I): O
}

internal class ListResponseToMedicationDomainModelMapper :
    Mapper<ListResponse, MedicationDomainModel> {
    override fun map(input: ListResponse): MedicationDomainModel = with(input) {
        MedicationDomainModel(
            id = id,
            name = name,
            info = description,
            image = image
        )
    }
}

internal class ListResponseListToMedicationDomainModelListMapper(
    private val listResponseToMedicationDomainModelMapper: ListResponseToMedicationDomainModelMapper
) :
    Mapper<List<ListResponse>, List<MedicationDomainModel>> {
    override fun map(input: List<ListResponse>): List<MedicationDomainModel> = with(input) {
        input.map { listResponseToMedicationDomainModelMapper.map(it) }
    }
}