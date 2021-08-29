package com.example.presentation.di

import com.example.presentation.viewmodel.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val presentationModule = module {

    viewModel { PokemonListViewModel(get()) }
}