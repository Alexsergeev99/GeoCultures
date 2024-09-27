package ru.alexsergeev.presentation.utils

import ru.alexsergeev.domain.models.MedicationDomainModel
import ru.alexsergeev.presentation.models.MedicationUiModel

interface Mapper<in I, out O> {
    fun map(input: I): O
}

internal class DomainMedicationToUiMedicationMapper() :
    Mapper<MedicationDomainModel, MedicationUiModel> {
    override fun map(input: MedicationDomainModel): MedicationUiModel = with(input) {
        MedicationUiModel(id = id, name = name, image = image, info = info)
    }
}

internal class DomainMedicationListToUiMedicationListMapper(
    private val domainMedicationToUiMedicationMapper: DomainMedicationToUiMedicationMapper
) :
    Mapper<List<MedicationDomainModel>, List<MedicationUiModel>> {
    override fun map(input: List<MedicationDomainModel>): List<MedicationUiModel> = with(input) {
        input.map { domainMedicationToUiMedicationMapper.map(it) }
    }
}