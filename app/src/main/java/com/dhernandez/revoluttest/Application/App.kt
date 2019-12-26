package com.dhernandez.revoluttest.Application

import android.app.Application
import com.dhernandez.revoluttest.Application.di.appModules
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin


class App : Application(), KoinComponent {

    init {
        startKoin {
            modules(appModules)
        }
    }

}