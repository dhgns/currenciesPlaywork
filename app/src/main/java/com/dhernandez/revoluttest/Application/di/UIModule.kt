package com.dhernandez.revoluttest.Application.di

import androidx.lifecycle.MutableLiveData
import com.dhernandez.revoluttest.Application.App
import com.dhernandez.revoluttest.Modules.RevolutCurrency
import com.dhernandez.revoluttest.Modules.splash.view.SplashActivity
import com.dhernandez.revoluttest.Modules.splash.viewmodel.SplashViewModel
import com.dhernandez.revoluttest.Modules.home.view.HomeActivity
import com.dhernandez.revoluttest.Modules.home.viewmodel.HomeViewModel
import com.dhernandez.revoluttest.Services.IRevolutAPI
import com.dhernandez.revoluttest.Services.Network
import com.dhernandez.revoluttest.Utils.NavigationMap
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.util.*


val uiModule = module {

    //Activites
    factory { SplashActivity() }
    factory { HomeActivity() }

    //Fragments

    //ViewModels
    viewModel { SplashViewModel(get(named("navigation"))) }
    viewModel { HomeViewModel(get()) }

    //SharedData
    single(named("navigation")) { MutableLiveData<NavigationMap>() }
    single(named("currencies")) { MutableLiveData<List<RevolutCurrency>>() }

    //Network
    factory<IRevolutAPI> { Network() }

}