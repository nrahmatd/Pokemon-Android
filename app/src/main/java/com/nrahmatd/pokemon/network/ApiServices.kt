package com.nrahmatd.pokemon.network

import com.nrahmatd.pokemon.model.PokemonModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    @GET(Api.POKEMON)
    suspend fun getPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonModel>
}