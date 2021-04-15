package com.example.myapplication.controllers

import com.example.myapplication.activities.App
import com.example.myapplication.entity.UserInfo
import com.example.myapplication.entity.Widget
import com.example.myapplication.interfaces.ApiResponce
import com.example.myapplication.repository.ApiHelper

class ControllerApi(private val apiHelper: ApiHelper) {

    suspend fun getWidgets(user: UserInfo, callback: ApiResponce<List<Widget>>) {
        apiHelper.getWidgets(user.getId(), App.lang, callback)
    }

}