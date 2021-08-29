package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.db.entities.Pokemon
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    fun getAll(): Single<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getById(id: Int): Single<Pokemon>

    @Insert
    fun save(pokemon: Pokemon): Completable

    @Delete
    fun delete(pokemon: Pokemon): Completable
}