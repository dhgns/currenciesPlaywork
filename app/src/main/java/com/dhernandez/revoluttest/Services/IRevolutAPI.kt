package com.dhernandez.revoluttest.Services

import com.dhernandez.revoluttest.Modules.RevolutCurrenciesRate
import io.reactivex.Single
import retrofit2.http.GET


interface IRevolutAPI {

    @GET("/latest?base=EUR")
    fun fetchCurrencies(): Single<RevolutCurrenciesRate>

}
