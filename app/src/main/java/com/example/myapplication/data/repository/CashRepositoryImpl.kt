package com.example.myapplication.data.repository

import com.example.myapplication.App
import com.example.myapplication.data.datasource.WidgetDatabase
import com.example.myapplication.data.entity.toWidget
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.domain.entity.toWidgetDto
import com.example.myapplication.domain.repository.CashRepository
import io.reactivex.Single
import javax.inject.Inject

class CashRepositoryImpl @Inject constructor(val database: WidgetDatabase): CashRepository {

    override fun getItems(): Single<List<Widget>?> = Single.defer {
        Single.just(database.widgetListDao().getItems().map { it.toWidget() })
    }

    override fun saveItems(items: List<Widget>): Single<List<Long>> = Single.defer {
        Single.just(database.widgetListDao().add(items.map { it.toWidgetDto() }))
    }

}