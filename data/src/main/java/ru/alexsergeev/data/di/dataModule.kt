package ru.alexsergeev.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.data.api.provideApiService
import ru.alexsergeev.data.api.provideOkHttpClient
import ru.alexsergeev.data.api.provideRetrofit
import ru.alexsergeev.data.repository.MainRepositoryImpl
import ru.alexsergeev.domain.repository.MainRepository

val dataModule = module {

    singleOf(::MainRepositoryImpl) bind MainRepository::class

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
}