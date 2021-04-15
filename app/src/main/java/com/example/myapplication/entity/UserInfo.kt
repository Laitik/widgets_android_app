package com.example.myapplication.entity

import java.lang.IllegalArgumentException

class UserInfo {
   private var id: Long = -1
   fun setId(value: Long): UserInfo {
       id = value
       return this
   }
   fun getId(): Long { return id }

   fun build(): UserInfo {
       if (id < 0) throw IllegalArgumentException("ID is not defined")
       return this
   }

    companion object {
        const val TABLE_NAME = "UserInfo"
    }
}