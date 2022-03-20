package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.WidgetCallApi
import com.example.myapplication.data.datasource.WidgetDatabase
import com.example.myapplication.data.repository.CashRepositoryImpl
import com.example.myapplication.data.repository.MircoserviceRepositoryImpl
import com.example.myapplication.domain.entity.UserInfo
import com.example.myapplication.domain.repository.CashRepository
import com.example.myapplication.domain.repository.RemoteServiceRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideUserInfo(): UserInfo = UserInfo(120L)

    @Provides
    fun provideDataBase(context: Context): WidgetDatabase =
        Room.databaseBuilder(context, WidgetDatabase::class.java, "database").build()

    @Provides
    fun provideCashRepository(database: WidgetDatabase): CashRepository =
        CashRepositoryImpl(database)

    @Provides
    fun provideRemoteServiceRepository(): RemoteServiceRepository = MircoserviceRepositoryImpl(
        Retrofit.Builder().baseUrl("https://widgets.newton-studio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WidgetCallApi::class.java)
    )

}