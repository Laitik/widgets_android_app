package com.example.myapplication.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.myapplication.activities.App
import com.example.myapplication.controllers.ControllerApi
import com.example.myapplication.entity.Widget
import com.example.myapplication.helper.ViewModelScope
import com.example.myapplication.interfaces.ApiResponce
import com.example.myapplication.repository.ApiHelper
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.launch

class WidgetViewModel: ViewModelScope() {
    private val controllerApi = ControllerApi(ApiHelper(App.apiService))
    private val repo = Repository()

    public fun getItems(): LiveData<List<Widget>?> {
        val data = repo.subscribeItemsUpdate()
        if (data.value == null || data.value!!.isEmpty()) {
            scope.launch {
                controllerApi.getWidgets(App.user, object : ApiResponce<List<Widget>> {
                    override fun result(items: List<Widget>?) {
                        items?.let {
                            scope.launch {
                                repo.saveItems(it)
                            }
                        } ?: run {
                            error("Нет данных")
                        }
                    }

                    override fun error(message: String) {
                        Toast.makeText(App.context, message, Toast.LENGTH_SHORT).show()
                    }
                })
            }
         }
        return data
    }


    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}