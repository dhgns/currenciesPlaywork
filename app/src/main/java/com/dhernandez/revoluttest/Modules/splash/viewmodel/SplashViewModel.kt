package com.dhernandez.revoluttest.Modules.splash.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dhernandez.revoluttest.Utils.NavigationMap
import java.util.*
import kotlin.concurrent.schedule


class SplashViewModel(
    private val navView: MutableLiveData<NavigationMap>
) : ViewModel(),
    ISplashViewModel {

    init {
        navView.value = NavigationMap.Splash

        Timer("SplashDelay", false).schedule(3000) {
            goToMain()
        }

    }

    private fun goToMain() {
        navView.postValue(NavigationMap.Home)
    }


    override fun goTo(): MutableLiveData<NavigationMap> {
        return navView
    }


}