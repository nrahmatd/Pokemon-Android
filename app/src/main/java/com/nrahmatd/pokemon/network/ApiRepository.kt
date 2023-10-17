package com.nrahmatd.pokemon.network

class ApiRepository {

    private var apiServices: ApiServices =
        RetrofitHelper.invoke(
            Api.BASEURL
        ).create(ApiServices::class.java)

    suspend fun getPokemon(limit: Int, offset: Int) = apiServices.getPokemon(limit, offset)
}