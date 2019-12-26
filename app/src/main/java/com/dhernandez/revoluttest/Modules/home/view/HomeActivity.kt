package com.dhernandez.revoluttest.Modules.home.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhernandez.revoluttest.Modules.RevolutCurrency
import com.dhernandez.revoluttest.Modules.home.view.adapters.CurrencyAdapter
import com.dhernandez.revoluttest.Modules.home.viewmodel.HomeViewModel
import com.dhernandez.revoluttest.Modules.home.viewmodel.IHomeViewModel
import com.dhernandez.revoluttest.R
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val presenter: IHomeViewModel by viewModel<HomeViewModel>()
    private lateinit var adapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    override fun onResume() {
        super.onResume()

        loadAdapter()

        presenter.getShowError().observe(this, Observer {
            Toast.makeText(this, resources.getString(it), Toast.LENGTH_LONG).show()
        })

        presenter.getCurrencies().observe(this, Observer {
            adapter.setCurrencies(it as ArrayList<RevolutCurrency>)
        })

        presenter.fetchCurrencies()

    }


    private fun loadAdapter() {

        adapter = CurrencyAdapter(this, presenter)

        rv_currencies.adapter = adapter

        //Load the layouts managers to the RV's
        rv_currencies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }


}
