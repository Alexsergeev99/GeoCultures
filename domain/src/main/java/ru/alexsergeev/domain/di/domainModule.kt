package ru.alexsergeev.domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.domain.usecase.implementation.GetMedicationListUseCaseImpl
import ru.alexsergeev.domain.usecase.interfaces.GetMedicationListUseCase

val domainModule = module {
    factoryOf(::GetMedicationListUseCaseImpl) bind GetMedicationListUseCase::class
}