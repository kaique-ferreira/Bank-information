package com.aruana.bankinformation

import android.app.Application
import com.aruana.bankinformation.di.AppComponent
import com.aruana.bankinformation.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}