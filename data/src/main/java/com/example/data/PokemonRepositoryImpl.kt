package com.example.data

import com.example.data.api.service.PokemonService
import com.example.data.mappers.PokemonMapper
import com.example.domain.models.PokemonModel
import com.example.domain.repository.PokemonRepository
import io.reactivex.Single

class PokemonRepositoryImpl(
    private val pokemonService: PokemonService,
) : PokemonRepository {

    override fun getPokemons(limit: Int, offset: Int): Single<List<PokemonModel>> {
        return pokemonService.getPokemons(
            limit = limit,
            offset = offset,
        ).map {
            it.results.map(PokemonMapper::mapPokemonApiModelToDomain)
        }
    }
}