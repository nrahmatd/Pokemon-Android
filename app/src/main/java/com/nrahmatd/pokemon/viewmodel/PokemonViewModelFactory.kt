package com.nrahmatd.pokemon.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.nrahmatd.pokemon.network.ApiRepository

class PokemonViewModelFactory : ViewModelProvider.Factory {

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        @Suppress("UNCHECKED_CAST")
        return PokemonViewModel(ApiRepository()) as T
    }
}
