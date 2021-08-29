package com.example.core.di

import android.app.Application
import com.example.core.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

open class BaseKoinApplication : Application() {

    private val koinModuleProviders = mutableListOf<DiModuleProvider>()

    fun registerModuleProviders(vararg moduleProviders: DiModuleProvider) {
        koinModuleProviders.addAll(moduleProviders.toList())
    }

    protected fun addRegistrar(registrar: DiModuleProviderRegistrar) {
        registrar.register(this)
    }

    override fun onCreate() {
        super.onCreate()

        val koinModules = koinModuleProviders
            .map { it.provide() }

        startKoin {

            if (BuildConfig.DEBUG) {
                androidLogger(level = Level.DEBUG)
            }

            androidContext(this@BaseKoinApplication)

            modules(koinModules)
        }
    }
}