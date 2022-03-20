package com.example.myapplication.presentation.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.domain.controllers.ControllerApi
import com.example.myapplication.domain.entity.UserInfo
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.domain.repository.CashRepository
import com.example.myapplication.presentation.base.viewmodel.BaseViewModel

class WidgetViewModel(
    private val userInfo: UserInfo,
    private val controllerApi: ControllerApi,
    private val database: CashRepository
) : BaseViewModel() {

    private val TAG = WidgetViewModel::class.java.simpleName

    private val _itemData: MutableLiveData<List<Widget>?> = MutableLiveData()
    val itemData: LiveData<List<Widget>?> = _itemData

    fun getItems() = database.getItems()
        .compose(doAsyncSingle())
        .subscribe({
            it?.let { _itemData.postValue(it) } ?: loadItemsFromService()
        }, {
            Log.e(TAG, it.cause?.message ?: "Ошибка получения данных с БД")
        }).addToComposite()

    fun saveItems(items: List<Widget>) = database.saveItems(items)
        .compose(doAsyncSingle())
        .subscribe({
            Log.e("", "")
        }, {
            Log.e(TAG, it.cause?.message ?: "Ошибка добавления данных в БД")
        }).addToComposite()

    private fun loadItemsFromService() =
        controllerApi.getWidgets(userInfo)
            .compose(doAsyncSingle())
            .subscribe({
                _itemData.postValue(it)
                saveItems(it)
            }, {
                Log.e(TAG, it.cause?.message ?: "Ошибка запроса виджетов с сервиса")
            }).addToComposite()

}