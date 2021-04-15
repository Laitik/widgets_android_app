package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.database.dao.WidgetListDao
import com.example.myapplication.entity.Widget

@Database(entities = [ Widget::class ] , version = 1)
public abstract class Database: RoomDatabase() {
    public abstract fun widgetListDao(): WidgetListDao
}