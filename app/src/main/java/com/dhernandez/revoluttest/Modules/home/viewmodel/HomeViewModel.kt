package com.dhernandez.revoluttest.Modules.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dhernandez.revoluttest.Modules.RevolutCurrency
import com.dhernandez.revoluttest.R
import com.dhernandez.revoluttest.Services.IRevolutAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class HomeViewModel(private val revolutAPI: IRevolutAPI) : ViewModel(), IHomeViewModel {

    private val currencies = MutableLiveData<List<RevolutCurrency>>()
    private val showError = MutableLiveData<Int>()
    private val disposable = CompositeDisposable()
    private val isEditing = AtomicBoolean(false)

    init {
        currencies.value = ArrayList()
    }

    override fun getCurrencies(): MutableLiveData<List<RevolutCurrency>> {
        return currencies
    }

    override fun getShowError(): MutableLiveData<Int> {
        return showError
    }

    override fun convertCurrency(currencyPos: Int, value: String) {

    }

    override fun isEditing(): AtomicBoolean {
        return isEditing
    }

    override fun updateFirstCurrency(position: Int) {

        val newSort = currencies.value!! as ArrayList
        val newTop = currencies.value!![position]

        newSort.remove(newTop)
        newSort.add(0, newTop)

        currencies.value = newSort

    }

    override fun fetchCurrencies() {

        disposable.add(
            revolutAPI.fetchCurrencies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    val retCurrencies = ArrayList<RevolutCurrency>()
                    retCurrencies.add(RevolutCurrency("EUR", 1.00))

                    //Map the response to filter the desires values
                    retCurrencies.addAll(it.rates.rates.map {
                        RevolutCurrency(it.country, it.value)
                    })

                    if (!isEditing.get())
                        currencies.value = retCurrencies

                    //Schedule the task to execute the fetch again after one second
                    //We can do it like this, or with a service in background
                    Timer("UpdateService", true).schedule(1000) {
                        fetchCurrencies()
                    }

                }, {
                    currencies.value = ArrayList()
                    showError.value = R.string.errorFetchingCurrencies
                })
        )


    }


}