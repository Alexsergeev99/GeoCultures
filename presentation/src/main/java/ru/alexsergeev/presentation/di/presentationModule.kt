package ru.alexsergeev.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.alexsergeev.presentation.utils.DomainMedicationListToUiMedicationListMapper
import ru.alexsergeev.presentation.utils.DomainMedicationToUiMedicationMapper
import ru.alexsergeev.presentation.viewmodel.MedicationViewModel

val presentationModule = module {

    viewModelOf(::MedicationViewModel)

    singleOf(::DomainMedicationToUiMedicationMapper)
    singleOf(::DomainMedicationListToUiMedicationListMapper)
}