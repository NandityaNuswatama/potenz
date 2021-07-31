package com.nandits.potenz.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
                localModule, adapterModule, networkModule, viewModelModule, repositoryModule
            )
        }
    }
}