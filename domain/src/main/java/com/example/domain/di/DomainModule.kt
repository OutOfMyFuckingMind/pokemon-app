package com.example.domain.di

import com.example.domain.usecase.GetPokemonListImpl
import com.example.domain.usecase.GetPokemonListUseCase
import org.koin.dsl.module

internal val domainModule = module {

    factory<GetPokemonListUseCase> { GetPokemonListImpl(get()) }
}