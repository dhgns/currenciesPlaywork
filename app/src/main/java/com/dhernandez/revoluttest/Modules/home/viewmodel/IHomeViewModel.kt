package com.dhernandez.revoluttest.Modules.home.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dhernandez.revoluttest.Modules.RevolutCurrenciesRate
import com.dhernandez.revoluttest.Modules.RevolutCurrency
import java.util.concurrent.atomic.AtomicBoolean

interface IHomeViewModel {

    fun getCurrencies(): MutableLiveData<RevolutCurrenciesRate>

    fun fetchCurrencies()
    fun getShowError(): MutableLiveData<Int>
    fun convertCurrency(currencyPos: Int, value: String)
    fun isEditing(): AtomicBoolean

}