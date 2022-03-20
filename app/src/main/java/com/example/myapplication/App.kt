package com.example.myapplication

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.datasource.WidgetDatabase
import com.example.myapplication.domain.entity.UserInfo
import com.example.myapplication.data.WidgetCallApi
import com.example.myapplication.di.AppComponent
import com.example.myapplication.di.DaggerAppComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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