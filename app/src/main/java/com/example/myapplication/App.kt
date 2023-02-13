package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.di.AppComponent
import com.example.myapplication.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}

fun Context.getAppContext(): AppComponent {
    return (this.applicationContext as App).appComponent
}