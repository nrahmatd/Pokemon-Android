package com.nrahmatd.pokemon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nrahmatd.pokemon.app.GlobalApp
import com.nrahmatd.pokemon.databinding.ItemPokemonBinding
import com.nrahmatd.pokemon.model.PokemonModel
import com.nrahmatd.pokemon.network.Api

class PokemonAdapter(
    private var pokemonList: List<PokemonModel.Result>
) : RecyclerView.Adapter<PokemonAdapter.ImageViewHolder>() {

    class ImageViewHolder(private val itemPokemonBinding: ItemPokemonBinding) : RecyclerView.ViewHolder(itemPokemonBinding.root) {
        val image = itemPokemonBinding.ivPokemon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder = ImageViewHolder(
        ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(GlobalApp.getAppContext()).load("${Api.BASEIMAGEURL}${pokemonList[position].name}.jpg").into(holder.image)
    }
}
