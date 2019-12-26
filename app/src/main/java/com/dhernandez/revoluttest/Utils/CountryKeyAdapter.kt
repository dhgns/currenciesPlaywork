package com.dhernandez.revoluttest.Utils

import com.dhernandez.revoluttest.Modules.Rate
import com.dhernandez.revoluttest.Modules.Rates
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class CountryCodeDeserializer : JsonDeserializer<Rates> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Rates {

        val rates = Rates()

        (json as JsonObject).entrySet().map {
            try {
                rates.rates.add(Rate(it.key, it.value.asDouble))
            } catch (e: Exception) {
            }
        }

        return rates

    }

}
