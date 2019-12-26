package com.dhernandez.revoluttest.Modules

import java.util.function.DoubleConsumer

data class RevolutCurrency(val country: String, var rate: Double)

data class RevolutCurrenciesResponse(
    val base: String,
    val date: String,
    val rates: Rates
)

class Rates {

    val rates: ArrayList<Rate> = ArrayList()

}

data class Rate(
    val country: String,
    val value: Double
)

class TopCurrencyVO(val country: String, var rate: Double, var value: Double)