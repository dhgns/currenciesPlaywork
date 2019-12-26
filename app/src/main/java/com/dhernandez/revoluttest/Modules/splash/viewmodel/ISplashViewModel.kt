package com.dhernandez.revoluttest.Modules.splash.viewmodel

import android.provider.SyncStateContract
import androidx.lifecycle.MutableLiveData
import com.dhernandez.revoluttest.Utils.NavigationMap

interface ISplashViewModel {

    fun goTo(): MutableLiveData<NavigationMap>

}