package com.example.domain.di

import com.example.core.di.BaseKoinApplication
import com.example.core.di.DiModuleProviderRegistrar

class DomainModuleProviderRegistrar : DiModuleProviderRegistrar {

    override fun register(app: BaseKoinApplication) {
        app.registerModuleProviders(DomainDiModuleProvider)
    }
}