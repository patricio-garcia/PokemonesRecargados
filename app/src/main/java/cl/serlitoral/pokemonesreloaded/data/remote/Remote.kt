package cl.serlitoral.pokemonesreloaded.data.remote

import cl.serlitoral.pokemonesreloaded.data.pojo.Pokemon
import cl.serlitoral.pokemonesreloaded.data.pojo.PokemonDetail
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

//https://lapi-pokemon.herokuapp.com/pokemon
//https://lapi-pokemon.herokuapp.com/pokemon/1

interface PokeAPI {
    @GET("pokemon")
    suspend fun getPokemones(): Response<List<Pokemon>>

    @GET("pokemon/{pid}")
    suspend fun getPokemon(@Path("pid") id: String): Response<PokemonDetail>
}

class RetrofitClient {
    companion object {
        private const val BASE_URL =  "https://lapi-pokemon.herokuapp.com/"

        fun retrofitInstance(): PokeAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create())
                .build()

            return retrofit.create(PokeAPI::class.java)
        }
    }
}

