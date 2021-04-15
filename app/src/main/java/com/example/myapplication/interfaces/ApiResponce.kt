package com.example.myapplication.interfaces

interface ApiResponce<T> {
    public fun result(items: T?)
    public fun error(message: String)
}