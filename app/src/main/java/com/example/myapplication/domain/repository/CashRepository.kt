package com.example.myapplication.domain.repository

import com.example.myapplication.domain.entity.Widget
import io.reactivex.Single

interface CashRepository {
    fun getItems(): Single<List<Widget>?>

    fun saveItems(items: List<Widget>): Single<List<Long>>
}