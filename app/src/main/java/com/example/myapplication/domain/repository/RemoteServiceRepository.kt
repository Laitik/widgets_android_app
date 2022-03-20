package com.example.myapplication.domain.repository

import com.example.myapplication.domain.entity.Widget
import io.reactivex.Single

interface RemoteServiceRepository {
    fun getWidgets(UserID: Long, locale: String): Single<List<Widget>>
}