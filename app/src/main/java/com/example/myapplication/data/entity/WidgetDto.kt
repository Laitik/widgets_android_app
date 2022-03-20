package com.example.myapplication.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.data.entity.WidgetDto.Companion.TABLE_NAME
import com.example.myapplication.domain.entity.Widget
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_NAME)
data class WidgetDto(
    @PrimaryKey
    val id: Long = 0,
    val name: String = String(),
    val descr: String = String(),
    @SerializedName("picturePreview")
    val avatarUrl: String = String()
) {
    companion object {
        const val TABLE_NAME = "Widget"
    }
}

fun WidgetDto.toWidget() = Widget(
    id = id,
    name = name,
    descr = descr,
    avatarUrl = avatarUrl
)