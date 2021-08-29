package com.example.data.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonListItemApiModel(

    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "base_experience")
    val baseExperience: Int,

    @field:Json(name = "height")
    val height: Int,

    @field:Json(name = "is_default")
    val isDefault: Boolean,

    @field:Json(name = "order")
    val order: Int,

    @field:Json(name = "weight")
    val weight: Int,
)