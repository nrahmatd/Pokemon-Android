package com.nrahmatd.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrahmatd.pokemon.network.ApiRepository
import com.nrahmatd.pokemon.network.ResponseHelper
import com.nrahmatd.pokemon.network.exception.ApiException
import com.nrahmatd.pokemon.network.exception.NoInternetException
import com.nrahmatd.pokemon.network.setRequest
import com.nrahmatd.pokemon.network.setResponse
import kotlinx.coroutines.launch

class PokemonViewModel(private val repository: ApiRepository) : ViewModel() {

    var response = MutableLiveData<ResponseHelper>()

    fun getPokemon(code_request: Int, limit: Int, offset: Int) = viewModelScope.launch {
        setResponse(response, ResponseHelper.LOADING, true)
        try {
            val request = repository.getPokemon(limit, offset)
            setRequest(response, request, code_request)
            setResponse(response, ResponseHelper.LOADING, false)
        } catch (e: Exception) {
            if (e is ApiException || e is NoInternetException) {
                setResponse(response, ResponseHelper.ERROR, e.message!!)
                setResponse(response, ResponseHelper.LOADING, false)
            }
        }
    }
}
