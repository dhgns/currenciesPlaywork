package com.dhernandez.revoluttest.Services

import com.dhernandez.revoluttest.BuildConfig
import com.dhernandez.revoluttest.Modules.RevolutCurrenciesRate
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Network : IRevolutAPI {

    private val revolutAPI: IRevolutAPI

    init {

        val gson = GsonBuilder()
            .create()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.BaseURL)
            .client(OkHttpClient())
            .build()

        revolutAPI = retrofit.create(IRevolutAPI::class.java)

    }

    override fun fetchCurrencies(): Single<RevolutCurrenciesRate> {

        return revolutAPI.fetchCurrencies().map {
            it
        }.doOnError {

        }


    }
}