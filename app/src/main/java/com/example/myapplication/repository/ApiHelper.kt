package com.example.myapplication.repository

import com.example.myapplication.entity.Widget
import com.example.myapplication.interfaces.ApiResponce
import com.example.myapplication.interfaces.WidgetCallApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiHelper(private val widgetCappApi: WidgetCallApi) {

     fun getWidgets(UserID: Long, locale: String, callback: ApiResponce<List<Widget>>?) {
        val call = widgetCappApi.getWidgets(UserID, locale)
        call.enqueue ( object : Callback<List<Widget>> {
            override fun onFailure(call: Call<List<Widget>>, t: Throwable) {
                t.message?.let { callback?.error(it) }
            }

            override fun onResponse(call: Call<List<Widget>>, response: Response<List<Widget>>) {
                response.body()?.let { callback?.result(it) }
            }

        } )
    }

}