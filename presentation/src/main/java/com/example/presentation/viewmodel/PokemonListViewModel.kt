package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.domain.models.PokemonModel
import com.example.domain.usecase.GetPokemonListUseCase

class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase,
) : BaseViewModel() {

    val pokemonList = MutableLiveData<List<PokemonModel>>()

    private var currentPage = 1

    init {
        loadNewPage()
    }

    fun getNextPage() {
        loadNewPage()
    }

    private fun loadNewPage() {
        getPokemonListUseCase(currentPage)
            .doOnSuccess { currentPage++ }
            .subscribe(
                { pokemonList.postValue(it) },
                { Log.e(TAG, it.toString()) }
            ).disposeOnFinish()
    }

    companion object {
        private const val TAG = "PokemonListViewModel"
    }
}