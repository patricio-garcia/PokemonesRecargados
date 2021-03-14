package cl.serlitoral.pokemonesreloaded.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemones(pokemones: List<PokemonEntity>)

    @Query("SELECT * FROM poke_entity")
    fun getPokemones(): LiveData<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(pokemones: PokemonDetailEntity)

    @Query("SELECT * FROM poke_detail WHERE id=:pid")
    fun getPokemon(pid: String): LiveData<PokemonDetailEntity>
}