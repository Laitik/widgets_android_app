package com.example.myapplication.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.datasource.dao.WidgetListDao
import com.example.myapplication.data.entity.WidgetDto

@Database(entities = [WidgetDto::class], version = 1)
abstract class WidgetDatabase : RoomDatabase() {
    abstract fun widgetListDao(): WidgetListDao
}