package com.example.domain.usecase

import com.example.domain.models.PokemonModel
import com.example.domain.repository.PokemonRepository
import io.reactivex.Single

class GetPokemonListImpl(
    private val pokemonRepository: PokemonRepository,
) : GetPokemonListUseCase {

    override operator fun invoke(page: Int): Single<List<PokemonModel>> {
        return pokemonRepository.getPokemons(
            limit = ITEMS_PER_PAGE,
            offset = ITEMS_PER_PAGE * page
        )
    }

    companion object {
        private const val ITEMS_PER_PAGE = 50
    }
}