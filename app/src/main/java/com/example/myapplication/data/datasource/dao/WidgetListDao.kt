package com.example.myapplication.data.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.entity.WidgetDto

@Dao
interface WidgetListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(widgetDto: WidgetDto): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(WidgetDto: List<WidgetDto>): List<Long>

    @Query("Select * From ${WidgetDto.TABLE_NAME}")
    fun getItems(): List<WidgetDto>

    @Query("DELETE FROM ${WidgetDto.TABLE_NAME} WHERE id = :id")
    fun delete(id: Int): Int

    @Query("DELETE FROM ${WidgetDto.TABLE_NAME}")
    fun deleteAll()
}