package com.dhernandez.revoluttest.Modules.home.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dhernandez.revoluttest.Modules.RevolutCurrency
import java.util.concurrent.atomic.AtomicBoolean

interface IHomeViewModel {

    fun getCurrencies(): MutableLiveData<List<RevolutCurrency>>

    fun fetchCurrencies()
    fun updateFirstCurrency(position: Int)
    fun getShowError(): MutableLiveData<Int>
    fun convertCurrency(currencyPos: Int, value: String)
    fun isEditing(): AtomicBoolean

}