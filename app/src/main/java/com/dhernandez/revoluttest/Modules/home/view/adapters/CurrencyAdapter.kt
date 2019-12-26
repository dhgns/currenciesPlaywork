package com.dhernandez.revoluttest.Modules.home.view.adapters

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dhernandez.revoluttest.Modules.RevolutCurrency
import com.dhernandez.revoluttest.Modules.TopCurrencyVO
import com.dhernandez.revoluttest.Modules.home.viewmodel.IHomeViewModel
import com.dhernandez.revoluttest.R
import com.dhernandez.revoluttest.Utils.Mapper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.vertical_collection_list_item.view.*

class CurrencyAdapter(private val context: Context, private val presenter: IHomeViewModel) :
    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private var currencies = ArrayList<RevolutCurrency>()
    private var topCurrency = MutableLiveData<TopCurrencyVO>()

    class ViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        fun loadView(
            data: ArrayList<RevolutCurrency>,
            position: Int,
            topCurrency: MutableLiveData<TopCurrencyVO>,
            presenter: IHomeViewModel
        ) {

            val currency = data[position]

            if (layoutPosition == 0) {
                topCurrency.value = TopCurrencyVO(currency.country, currency.rate, 0.0)

                view.et_currency_value.setOnFocusChangeListener { v, hasFocus ->
                    presenter.isEditing().getAndSet(hasFocus)
                }

            }

            topCurrency.observeForever {
                if (layoutPosition != 0)
                    view.et_currency_value.setText(convertValue(topCurrency.value!!, currency))
            }

            //Load image
            Picasso.get().load(Mapper.getCurrencyCountryFlag(currency.country))
                .placeholder(R.drawable.splash)
                .into(view.iv_currency_image)

            //Load currency
            view.tv_currency.text = currency.country

            //Load currency name
            view.tv_currency_name.text = Mapper.getCurrencyName(currency.country)

            //Load currency value
            view.et_currency_value.setText(currency.rate.toString())

            view.et_currency_value.setOnClickListener {
                view.callOnClick()
            }

            view.et_currency_value.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {

                    if (layoutPosition == 0) {
                        if (!s.isNullOrBlank())
                            topCurrency.value!!.value = s.toString().toDouble()
                        else
                            topCurrency.value!!.value = 0.0
                        topCurrency.value = topCurrency.value
                    }

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {

                }
            })

            view.setOnClickListener {
                presenter.updateFirstCurrency(position)
            }

        }

        private fun convertValue(
            convertFrom: TopCurrencyVO,
            convertTo: RevolutCurrency
        ): String {

            return "%.2f".format(convertFrom.value * convertTo.rate / convertFrom.rate)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.vertical_collection_list_item, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return currencies.size
    }

    fun setCurrencies(data: ArrayList<RevolutCurrency>) {

        if (!presenter.isEditing().get()) {
            this.currencies = data
            notifyDataSetChanged()
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadView(currencies, position, topCurrency, presenter)
    }


}