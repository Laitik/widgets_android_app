package com.example.myapplication.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Widget {
    @PrimaryKey
    var id: Long = 0
    var name: String = String()
    var descr: String = String()

    @SerializedName("picturePreview")
    var avatarUrl: String = String()

    companion object {
       const val TABLE_NAME = "Widget"
    }
}