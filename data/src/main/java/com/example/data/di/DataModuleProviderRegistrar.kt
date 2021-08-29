package com.example.data.di

import com.example.core.di.BaseKoinApplication
import com.example.core.di.DiModuleProviderRegistrar

class DataModuleProviderRegistrar : DiModuleProviderRegistrar {

    override fun register(app: BaseKoinApplication) {
        app.registerModuleProviders(
            NetworkDiModuleProvider,
            DatabaseDiModuleProvider,
        )
    }
}