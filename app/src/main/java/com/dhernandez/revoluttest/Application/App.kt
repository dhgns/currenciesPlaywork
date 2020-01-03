package com.dhernandez.revoluttest.Application

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashTest
import com.crashlytics.android.core.CrashlyticsNdkData
import com.crashlytics.android.core.CrashlyticsNdkDataProvider
import com.dhernandez.revoluttest.Application.di.appModules
import io.fabric.sdk.android.Fabric
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

    
class App : Application(), KoinComponent {

    init {
        startKoin {
            modules(appModules)
        }

    }

}