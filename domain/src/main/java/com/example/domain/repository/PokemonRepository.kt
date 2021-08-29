package com.example.domain.repository

import com.example.domain.models.PokemonModel
import io.reactivex.Single

interface PokemonRepository {
    fun getPokemons(limit: Int, offset: Int): Single<List<PokemonModel>>
}