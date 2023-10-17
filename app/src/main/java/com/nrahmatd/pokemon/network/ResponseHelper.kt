package com.nrahmatd.pokemon.network

class ResponseHelper(val code: Int, val response: Any) {

    companion object {
        const val ERROR = 0
        const val LOADING = -1

        const val OK = 200
        const val Created = 201
        const val BadReqest = 400
        const val Timeout = 200
    }
}