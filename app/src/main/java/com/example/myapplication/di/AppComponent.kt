package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.domain.controllers.ControllerApi
import com.example.myapplication.domain.entity.UserInfo
import com.example.myapplication.domain.repository.CashRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun getUserInfo() : UserInfo

    fun getControllerApi(): ControllerApi

    fun getCashRepository(): CashRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}