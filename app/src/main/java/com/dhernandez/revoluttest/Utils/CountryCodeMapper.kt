package com.dhernandez.revoluttest.Utils

object Mapper {

    fun getCurrencyCountryFlag(country: String): String {

        val code = when (country) {
            "AUD" -> "au"
            "BGN" -> "bg"
            "BRL" -> "br"
            "CAD" -> "ca"
            "CHF" -> "ch"
            "CNY" -> "cn"
            "CZK" -> "cz"
            "DKK" -> "dk"
            "GBP" -> "gb"
            "HKD" -> "hk"
            "HRK" -> "hr"
            "HUF" -> "hu"
            "IDR" -> "id"
            "ILS" -> "il"
            "INR" -> "in"
            "ISK" -> "is"
            "JPY" -> "jp"
            "KRW" -> "kr"
            "MXN" -> "mx"
            "MYR" -> "my"
            "NOK" -> "no"
            "NZD" -> "nz"
            "PHP" -> "ph"
            "PLN" -> "pl"
            "RON" -> "ro"
            "RUB" -> "ru"
            "SEK" -> "se"
            "SGD" -> "sg"
            "THB" -> "th"
            "TRY" -> "tr"
            "USD" -> "us"
            "ZAR" -> "za"
            else -> "eu"
        }

        return "https://www.countryflags.io/$code/flat/64.png"

    }

    fun getCurrencyName(country: String): String {

        return when (country) {
            "AUD" -> "Australian Dollar"
            "BGN" -> "Bulgarian lev"
            "BRL" -> "Brazilian real"
            "CAD" -> "Canadian Dollar"
            "CHF" -> "Swiss franc"
            "CNY" -> "Chinese Yuan"
            "CZK" -> "Czech koruna "
            "DKK" -> "Danish krone"
            "EUR" -> "Euro"
            "GBP" -> "Pound Sterling"
            "HKD" -> "Hong Kong Dollar"
            "HRK" -> "Croatian kuna"
            "HUF" -> "Hungarian forint"
            "IDR" -> "Indonesian rupiah"
            "ILS" -> "Israeli new shekel"
            "INR" -> "India Rupees"
            "ISK" -> "Icelandic króna"
            "JPY" -> "Japanese yen"
            "KRW" -> "South Korean won"
            "MXN" -> "Mexican peso"
            "MYR" -> "Malaysian Ringgit"
            "NOK" -> "Norwegian krone"
            "NZD" -> "New Zealand Dollar"
            "PHP" -> "Philippine Peso"
            "PLN" -> "Polish złoty"
            "RON" -> "Romanian leu"
            "RUB" -> "Russian Rouble"
            "SEK" -> "Swedish krona"
            "SGD" -> "Singapore Dollar"
            "THB" -> "Thailand Baht"
            "TRY" -> "Turkish lira"
            "USD" -> "US Dollar"
            "ZAR" -> "South African Rand"
            else -> "eu"
        }

    }


}