package com.nrahmatd.pokemon.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PokemonModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
) {
    @Keep
    data class Result(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )
}