package com.example.presentation.di

import com.example.core.di.BaseKoinApplication
import com.example.core.di.DiModuleProviderRegistrar

class PresentationModuleProviderRegistrar : DiModuleProviderRegistrar {

    override fun register(app: BaseKoinApplication) {
        app.registerModuleProviders(PresentationDiModuleProvider)
    }
}