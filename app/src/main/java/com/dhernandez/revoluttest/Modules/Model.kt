package com.dhernandez.revoluttest.Modules

import java.lang.reflect.Field

data class RevolutCurrency(val country: String, var rate: Double)

data class RevolutCurrenciesResponse(
    val base: String,
    val date: String,
    val rates: Rates
)

class TopCurrencyVO(val country: String, var rate: Double, var value: Double)


open class RevolutCurrenciesRate(
    val base: String,
    val date: String,
    val rates: Rates
)

open class Rates(
    val AUD: Double,
    val BGN: Double,
    val BRL: Double,
    val CAD: Double,
    val CHF: Double,
    val CNY: Double,
    val CZK: Double,
    val DKK: Double,
    val GBP: Double,
    val HKD: Double,
    val HRK: Double,
    val HUF: Double,
    val IDR: Double,
    val ILS: Double,
    val INR: Double,
    val ISK: Double,
    val JPY: Double,
    val KRW: Double,
    val MXN: Double,
    val MYR: Double,
    val NOK: Double,
    val NZD: Double,
    val PHP: Double,
    val PLN: Double,
    val RON: Double,
    val RUB: Double,
    val SEK: Double,
    val SGD: Double,
    val THB: Double,
    val TRY: Double,
    val USD: Double,
    val ZAR: Double
) {
    fun get(property: Field?) {
        this::class.java.declaredFields.forEach {

        }
    }
}