package com.example.data.api.service

import com.example.data.api.models.PokemonListItemApiModel
import com.example.data.api.response.PagedResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int = 0
    ): Single<PagedResponse>

    @GET("pokemon/{id}")
    fun getPokemonById(
        @Path("id") id: Int,
    ): Single<PokemonListItemApiModel>
}