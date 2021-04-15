package com.example.myapplication.activities

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.myapplication.database.Database
import com.example.myapplication.entity.UserInfo
import com.example.myapplication.interfaces.WidgetCallApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, Database::class.java, "database").build()
        context = applicationContext
    }


    companion object {
        var lang = "ru"
        private val server = "https://widgets.newton-studio.com"
        private fun getRetrofit()  = Retrofit.Builder().baseUrl(server).addConverterFactory(GsonConverterFactory.create()).build()

        val apiService = getRetrofit().create(WidgetCallApi::class.java)
        lateinit var database: Database

        val user = UserInfo().setId(120).build()
        lateinit var context: Context
    }
}