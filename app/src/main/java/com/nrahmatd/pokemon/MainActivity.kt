package com.nrahmatd.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nrahmatd.pokemon.adapter.PokemonAdapter
import com.nrahmatd.pokemon.databinding.ActivityMainBinding
import com.nrahmatd.pokemon.model.PokemonModel
import com.nrahmatd.pokemon.network.ResponseHelper
import com.nrahmatd.pokemon.viewmodel.PokemonViewModel
import com.nrahmatd.pokemon.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonViewModel: PokemonViewModel
    private lateinit var pokemonAdapter: PokemonAdapter

    companion object {
        const val POKEMON = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        getPokemon()
        getResponse()
    }

    private fun setupViewModel() {
        pokemonViewModel =
            ViewModelProvider(this, PokemonViewModelFactory())[PokemonViewModel::class.java]
    }

    private fun getPokemon() {
        pokemonViewModel.getPokemon(POKEMON, 10, 1)
    }

    private fun getResponse() {
        pokemonViewModel.response.observe(this) {
            when (it.code) {
                ResponseHelper.ERROR -> {
                    val error = it.response as String
                    println(error)
                }

                POKEMON -> {
                    val response = it.response as PokemonModel
                    populateAdapter(response)
                }
            }
        }
    }

    private fun populateAdapter(pokemonModel: PokemonModel) {
        pokemonAdapter = PokemonAdapter(pokemonModel.results)
        binding.rvPokemon.apply {
            this.adapter = pokemonAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }
}