package cl.serlitoral.pokemonesreloaded

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import cl.serlitoral.pokemonesreloaded.data.Repository
import cl.serlitoral.pokemonesreloaded.data.pojo.Pokemon
import cl.serlitoral.pokemonesreloaded.data.pojo.PokemonDetail
import kotlinx.coroutines.launch

class PokeViewModel : ViewModel() {

    private val repository = Repository()
    fun pokelist() : LiveData<List<Pokemon>> = repository.pokelist()

    fun getPokemones() {
        viewModelScope.launch {
            repository.getPokemones()
        }
    }

    // cuando te llegue el resultado, yo voy a ....
    fun getDetail(id: String): LiveData<PokemonDetail> = repository.getDetailFromDB(id)

    // consume o anda a buscar el valor para este ID
    fun consumeDetail(id: String) {
        viewModelScope.launch {
            repository.getDetail(id)
        }
    }


    private lateinit var selected : Pokemon

    fun setSelected(pokemon: Pokemon) {
        selected = pokemon
    }

    fun getSelected() = selected
}