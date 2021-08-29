package com.example.data.di

import androidx.room.Room
import com.example.data.PokemonRepositoryImpl
import com.example.data.db.PokemonDatabase
import com.example.domain.repository.PokemonRepository
import org.koin.dsl.module

const val DATABASE_NAME = "pokemon_database"

internal val dataModule = module {

    fun providePokemonDao(database: PokemonDatabase) = database.pokemonDao()

    single {
        Room.databaseBuilder(get(), PokemonDatabase::class.java, DATABASE_NAME)
            .build()
    }

    single {
        providePokemonDao(get())
    }

    single<PokemonRepository> {
        PokemonRepositoryImpl(get(), get())
    }
}