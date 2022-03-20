package com.example.myapplication.data.repository

import com.example.myapplication.data.entity.WidgetDto
import com.example.myapplication.data.WidgetCallApi
import com.example.myapplication.data.entity.toWidget
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.domain.repository.RemoteServiceRepository
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MircoserviceRepositoryImpl(private val widgetCappApi: WidgetCallApi) : RemoteServiceRepository {

    override fun getWidgets(UserID: Long, locale: String): Single<List<Widget>> {
        val call = widgetCappApi.getWidgets(UserID, locale)
        return Single.create { emitter ->
            call.enqueue(object : Callback<List<WidgetDto>> {
                override fun onFailure(call: Call<List<WidgetDto>>, t: Throwable) {
                    emitter.onError(t)
                }

                override fun onResponse(
                    call: Call<List<WidgetDto>>,
                    response: Response<List<WidgetDto>>
                ) {
                    response.body()?.let { emitter.onSuccess(it.map { item -> item.toWidget() }) }
                        ?: emitter.onError(Throwable("Remote service call error"))
                }

            })
        }
    }

}