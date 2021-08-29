package com.example.data.di

import com.example.core.di.DiModuleProvider

object DatabaseDiModuleProvider : DiModuleProvider {

    override fun provide() = dataModule
}