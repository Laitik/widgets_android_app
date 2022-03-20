package com.example.myapplication.data.repository

import com.example.myapplication.App
import com.example.myapplication.data.entity.toWidget
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.domain.entity.toWidgetDto
import com.example.myapplication.domain.repository.CashRepository
import io.reactivex.Single

class CashRepositoryImpl : CashRepository {

    override fun getItems(): Single<List<Widget>?> = Single.defer {
        Single.just(App.widgetDatabase.widgetListDao().getItems().map { it.toWidget() })
    }

    override fun saveItems(items: List<Widget>): Single<List<Long>> = Single.defer {
        Single.just(App.widgetDatabase.widgetListDao().add(items.map { it.toWidgetDto() }))
    }

}