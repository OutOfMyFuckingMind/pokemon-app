package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.dao.PokemonDao
import com.example.data.db.entities.Pokemon

@Database(
    version = 1,
    entities = [
        Pokemon::class,
    ]
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}