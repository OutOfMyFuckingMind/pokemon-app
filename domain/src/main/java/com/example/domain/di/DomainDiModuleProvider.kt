package com.example.domain.di

import com.example.core.di.DiModuleProvider

object DomainDiModuleProvider : DiModuleProvider {

    override fun provide() = domainModule
}