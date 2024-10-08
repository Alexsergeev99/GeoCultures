package ru.alexsergeev.geocultures

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.alexsergeev.data.di.dataModule
import ru.alexsergeev.domain.di.domainModule
import ru.alexsergeev.presentation.di.presentationModule
import kotlin.text.Typography.dagger

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(presentationModule, dataModule, domainModule)
        }
    }
}