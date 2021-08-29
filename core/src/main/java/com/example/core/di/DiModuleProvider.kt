package com.example.core.di

import org.koin.core.module.Module

interface DiModuleProvider {
    fun provide(): Module
}