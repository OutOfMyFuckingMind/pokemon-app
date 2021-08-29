package com.example.data.di

import com.example.core.di.DiModuleProvider
import org.koin.core.module.Module

object NetworkDiModuleProvider : DiModuleProvider {

    override fun provide(): Module {
        return networkModule
    }
}