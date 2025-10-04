package com.aradsheybak.flightticket

import android.app.Application
import com.aradsheybak.flightticket.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import com.jakewharton.threetenabp.AndroidThreeTen

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            modules(appModule)
        }
        AndroidThreeTen.init(this)

    }
}