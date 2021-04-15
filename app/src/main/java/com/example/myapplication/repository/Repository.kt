package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.activities.App
import com.example.myapplication.entity.Widget


class Repository() {

    fun subscribeItemsUpdate(): LiveData<List<Widget>?> {
        return App.database.widgetListDao().subscribeItemsUpdate()
    }

    suspend fun saveItems(items: List<Widget>): List<Long> {
        return App.database.widgetListDao().add(items)
    }

    suspend fun deleteItems() {
        return App.database.widgetListDao().deleteAll()
    }
}