package com.example.myapplication.data

import com.example.myapplication.data.entity.WidgetDto
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface WidgetCallApi {

    @Headers("Cache-Control: max-age=0, no-store, no-cache, must-revalidate")
    @POST("/InternetShop/hs/ntReg/Reg?fPut=GetWidgets")
    fun getWidgets(@Query("User") UserID: Long, @Query("locale") locale: String): Call<List<WidgetDto>>

}