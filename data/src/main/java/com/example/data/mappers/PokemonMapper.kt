package com.example.data.mappers

import com.example.data.api.response.PagedResponseItem
import com.example.domain.models.PokemonModel

object PokemonMapper {

    fun mapPokemonApiModelToDomain(pagedResponseItem: PagedResponseItem): PokemonModel {
        return PokemonModel(
            name = pagedResponseItem.name,
            url = pagedResponseItem.url,
        )
    }
}