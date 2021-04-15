package com.example.myapplication.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.entity.Widget

@Dao
interface WidgetListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(widget: Widget): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(Widget: List<Widget>): List<Long>

    @Query("Select * From ${Widget.TABLE_NAME}")
    fun getItems(): List<Widget>?

    @Query("Select * From ${Widget.TABLE_NAME}")
    fun subscribeItemsUpdate(): LiveData<List<Widget>?>

    @Query("DELETE FROM ${Widget.TABLE_NAME} WHERE id = :id")
    fun delete(id: Int): Int

    @Query("DELETE FROM ${Widget.TABLE_NAME}")
    fun deleteAll()
}