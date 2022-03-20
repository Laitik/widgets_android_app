package com.example.myapplication

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.datasource.WidgetDatabase
import com.example.myapplication.domain.entity.UserInfo
import com.example.myapplication.data.WidgetCallApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        widgetDatabase = Room.databaseBuilder(this, WidgetDatabase::class.java, "database").build()
        context = applicationContext
    }


    companion object {
        private const val USER_DEFAULT_ID = 120L

        lateinit var context: Context

        lateinit var widgetDatabase: WidgetDatabase

        var lang = "ru"

        val apiService = getRetrofit().create(WidgetCallApi::class.java)

        val user = UserInfo(USER_DEFAULT_ID)

        private fun getRetrofit() =
            Retrofit.Builder().baseUrl("https://widgets.newton-studio.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}