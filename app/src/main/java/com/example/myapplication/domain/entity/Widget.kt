package com.example.myapplication.domain.entity

import androidx.room.Entity
import com.example.myapplication.data.entity.WidgetDto

@Entity
data class Widget(
    val id: Long = 0,
    val name: String = String(),
    val descr: String = String(),
    val avatarUrl: String = String()
)

fun Widget.toWidgetDto() = WidgetDto(
    id = id,
    name = name,
    descr = descr,
    avatarUrl = avatarUrl
)