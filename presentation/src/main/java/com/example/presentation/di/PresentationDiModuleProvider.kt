package com.example.presentation.di

import com.example.core.di.DiModuleProvider

object PresentationDiModuleProvider : DiModuleProvider {

    override fun provide() = presentationModule
}