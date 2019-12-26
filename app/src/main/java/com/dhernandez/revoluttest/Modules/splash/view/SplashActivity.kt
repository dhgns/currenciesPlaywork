package com.dhernandez.revoluttest.Modules.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer
import com.dhernandez.revoluttest.Modules.home.view.HomeActivity
import com.dhernandez.revoluttest.Modules.splash.viewmodel.ISplashViewModel
import com.dhernandez.revoluttest.Modules.splash.viewmodel.SplashViewModel
import com.dhernandez.revoluttest.R
import com.dhernandez.revoluttest.Utils.NavigationMap
import org.koin.android.viewmodel.ext.android.viewModel


class SplashActivity : AppCompatActivity() {

    private val presenter: ISplashViewModel by viewModel<SplashViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)


    }

    override fun onResume() {
        super.onResume()

        presenter.goTo().observe(this, Observer {

            when (it) {
                NavigationMap.Splash -> {
                }
                NavigationMap.Home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                }
            }

        })
    }

}
