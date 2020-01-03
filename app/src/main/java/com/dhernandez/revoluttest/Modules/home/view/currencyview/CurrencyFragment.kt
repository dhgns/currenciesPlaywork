package com.dhernandez.revoluttest.Modules.home.view.currencyview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dhernandez.revoluttest.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.currency_fragment.*

class CurrencyFragment : Fragment() {

    private var name: String? = null
    private var rate: String? = null
    private var country: String? = null
    private var imageUri: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currency_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_currency_name.text = name
        tv_currency_country.text = country
        Picasso.get().load(imageUri).fit().into(civ_currency_image)
        et_currency_value.setText(rate)
    }

    fun setCurrencyName(name: String) {
        this.name = name
    }

    fun setCurrencyCountry(country: String) {
        this.country = country
    }

    fun setCurrencyImage(path: String) {
        this.imageUri = path
    }

    fun setCurrencyRate(rate: Double) {
        this.rate = rate.toString()
    }


}
