package com.example.myapplication.domain.controllers

import com.example.myapplication.App
import com.example.myapplication.domain.entity.UserInfo
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.domain.repository.RemoteServiceRepository
import io.reactivex.Single
import javax.inject.Inject

class ControllerApi @Inject constructor(private val mircoserviceRepositoryImpl: RemoteServiceRepository) {

    fun getWidgets(user: UserInfo): Single<List<Widget>> =
        mircoserviceRepositoryImpl.getWidgets(user.id, DEFAULT_LANG)

    companion object {
        var DEFAULT_LANG = "ru"
    }
}