package com.example.pokemon_app

import com.example.core.di.BaseKoinApplication
import com.example.data.di.DataModuleProviderRegistrar
import com.example.domain.di.DomainModuleProviderRegistrar
import com.example.presentation.di.PresentationModuleProviderRegistrar

class PokeApp : BaseKoinApplication() {

    override fun onCreate() {

        addRegistrar(DataModuleProviderRegistrar())
        addRegistrar(DomainModuleProviderRegistrar())
        addRegistrar(PresentationModuleProviderRegistrar())

        super.onCreate()
    }
}