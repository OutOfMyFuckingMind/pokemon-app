package com.example.pokemon_app

import com.example.core.di.BaseKoinApplication
import com.example.data.di.NetworkDiModuleProvider
import com.example.domain.di.DomainDiModuleProvider
import com.example.presentation.di.PresentationDiModuleProvider

class PokeApp : BaseKoinApplication() {

    override fun onCreate() {

        registerModuleProviders(
            NetworkDiModuleProvider,
            DomainDiModuleProvider,
            PresentationDiModuleProvider
        )

        super.onCreate()
    }
}