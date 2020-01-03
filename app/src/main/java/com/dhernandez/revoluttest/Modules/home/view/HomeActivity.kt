package com.dhernandez.revoluttest.Modules.home.view

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dhernandez.revoluttest.Modules.RevolutCurrenciesRate
import com.dhernandez.revoluttest.Modules.home.viewmodel.HomeViewModel
import com.dhernandez.revoluttest.Modules.home.viewmodel.IHomeViewModel
import com.dhernandez.revoluttest.R
import com.dhernandez.revoluttest.Utils.Mapper
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.reflect.Field


class HomeActivity : AppCompatActivity() {

    private val currenciesRates = HashMap<String, View?>()
    private val presenter: IHomeViewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    override fun onResume() {
        super.onResume()

        presenter.getShowError().observe(this, Observer {
            Toast.makeText(this, resources.getString(it), Toast.LENGTH_LONG).show()
        })

        presenter.getCurrencies().observe(this, Observer {
            updateLayout(it)
        })

        presenter.fetchCurrencies()

    }

    private fun shortCurrencies(currencyView: View?) {

        if (ll_currencies_container.indexOfChild(currencyView) != 0) {

            ll_currencies_container.removeView(currencyView)
            ll_currencies_container.addView(currencyView, 0)

        }

    }

    private fun updateLayout(rates: RevolutCurrenciesRate) {

        //Check if the currencies are already in the view. Count with the base currency
        if (ll_currencies_container.childCount != (rates.rates.javaClass.declaredFields.count() + 1))
            addCurrencies(rates)
        else
            updateRates(rates)

    }

    private fun addCurrencies(rates: RevolutCurrenciesRate) {

        //Add the base currency
        loadBaseCurrency(rates)

        //Inflate the rest of views
        rates.rates.javaClass.declaredFields.forEach {
            loadCurrencyView(rates, it)
        }

    }

    private fun loadCurrencyView(rates: RevolutCurrenciesRate, it: Field) {

        it.isAccessible = true

        val view: View? = layoutInflater.inflate(
            R.layout.currency_fragment,
            ll_currencies_container as ViewGroup,
            false
        )

        view?.findViewById<TextView>(R.id.tv_currency_name)?.text = it.name
        view?.findViewById<TextView>(R.id.tv_currency_country)?.text =
            Mapper.getCurrencyName(it.name)

        val currencyRateView: EditText? = view?.findViewById(R.id.et_currency_value)
        val flagIconView = view?.findViewById<CircleImageView>(R.id.civ_currency_image)

        currencyRateView?.setText((it.get(rates.rates) as Double).toString())
        Picasso.get().load(Mapper.getCurrencyCountryFlag(it.name)).into(flagIconView)

        view?.setOnClickListener {
            shortCurrencies(it)
        }

        this.currenciesRates[it.name] = currencyRateView

        ll_currencies_container.addView(view)

    }

    private fun loadBaseCurrency(rates: RevolutCurrenciesRate) {

        val baseView: View? = layoutInflater.inflate(
            R.layout.currency_fragment,
            ll_currencies_container as ViewGroup,
            false
        )

        baseView?.findViewById<TextView>(R.id.tv_currency_name)?.text = rates.base
        baseView?.findViewById<TextView>(R.id.tv_currency_country)?.text =
            Mapper.getCurrencyName(rates.base)

        val currencyBaseView: EditText? = baseView?.findViewById(R.id.et_currency_value)
        currencyBaseView?.setText((1.0).toString())

        val flagIconBaseView = baseView?.findViewById<CircleImageView>(R.id.civ_currency_image)
        Picasso.get().load(Mapper.getCurrencyCountryFlag(rates.base)).placeholder(R.drawable.splash).fit().into(flagIconBaseView)

        baseView?.setOnClickListener {
            shortCurrencies(it)
        }

        ll_currencies_container.addView(baseView)

    }

    private fun updateRates(rates: RevolutCurrenciesRate) {

        rates.rates.javaClass.declaredFields.forEach {
            (currenciesRates[it.name] as EditText?)?.setText(0.3.toString())
        }

    }


}
