package com.example.myapplication.domain.controllers

import com.example.myapplication.App
import com.example.myapplication.domain.entity.UserInfo
import com.example.myapplication.data.repository.MircoserviceRepositoryImpl
import com.example.myapplication.domain.entity.Widget
import io.reactivex.Single

class ControllerApi(private val mircoserviceRepositoryImpl: MircoserviceRepositoryImpl) {

    fun getWidgets(user: UserInfo): Single<List<Widget>> =
        mircoserviceRepositoryImpl.getWidgets(user.id, App.lang)

}