package com.example.domain.usecase

import com.example.domain.models.PokemonModel
import io.reactivex.Single

interface GetPokemonListUseCase {
    operator fun invoke(page: Int): Single<List<PokemonModel>>
}