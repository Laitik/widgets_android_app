package com.example.myapplication.presentation.screen

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.App
import com.example.myapplication.domain.controllers.ControllerApi
import com.example.myapplication.data.repository.MircoserviceRepositoryImpl
import com.example.myapplication.data.repository.CashRepositoryImpl
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.domain.repository.CashRepository
import com.example.myapplication.presentation.base.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WidgetViewModel : BaseViewModel() {
    private val TAG = WidgetViewModel::class.java.simpleName

    private val controllerApi = ControllerApi(MircoserviceRepositoryImpl(App.apiService))
    private val database: CashRepository = CashRepositoryImpl()

    private val _itemData: MutableLiveData<List<Widget>?> = MutableLiveData()
    val itemData: LiveData<List<Widget>?> = _itemData

    fun getItems() = database.getItems()
        .compose(doAsyncSingle())
        .subscribe({
            it?.let { _itemData.postValue(it) } ?: loadItemsFromService()
        }, {
            Log.e(TAG, it.cause?.message ?: "Ошибка получения данных с БД")
        }).addToComposite()

    fun saveItems(items: List<Widget>)= database.saveItems(items)
        .compose(doAsyncSingle())
        .subscribe({
            Log.e("", "")
        }, {
            Log.e(TAG, it.cause?.message ?: "Ошибка добавления данных в БД")
        }).addToComposite()

    private fun loadItemsFromService() =
        controllerApi.getWidgets(App.user)
            .compose(doAsyncSingle())
            .subscribe({
                _itemData.postValue(it)
                saveItems(it)
            }, {
                Toast.makeText(App.context, it.message, Toast.LENGTH_SHORT).show()
            }).addToComposite()

}