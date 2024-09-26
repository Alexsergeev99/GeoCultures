package ru.alexsergeev.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.alexsergeev.presentation.viewmodel.MedicationViewModel

val presentationModule = module {

    viewModelOf(::MedicationViewModel)

}