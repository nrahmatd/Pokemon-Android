package com.nrahmatd.pokemon.network

import androidx.lifecycle.MutableLiveData
import retrofit2.Response

fun <T> setRequest(
    liveData: MutableLiveData<ResponseHelper>,
    request: Response<T>,
    code_request: Int
) {
    when(request.code()) {
        ResponseHelper.OK, ResponseHelper.Created -> {
             println("Response body.. $liveData - ${request.body()}")
            setResponse(liveData, code_request, request.body() ?: "")
        }
        ResponseHelper.BadReqest, ResponseHelper.ERROR -> {
            print("Response Error...")
        }
    }
}

fun setResponse(liveData: MutableLiveData<ResponseHelper>, code: Int, value: Any) {
    liveData.value = ResponseHelper(code, value)
}