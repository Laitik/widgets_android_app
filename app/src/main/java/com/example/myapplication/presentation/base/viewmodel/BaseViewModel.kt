package com.example.myapplication.presentation.base.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {
    /**
     * Список подписок для очистки
     */
    private val disposableBag = CompositeDisposable()

    /**
     * Добавить подписку в список для последующей очистки
     *
     * @param disposable подписка, может быть null
     */
    fun withDisposable(disposable: Disposable) = disposable.also {  disposableBag.add(disposable) }

    /**
     * Добавить подписку в список для последующей очистки
     * @return подписка, которую необходимо очистить
     */
    fun Disposable.addToComposite(): Disposable = withDisposable(this)

    /**
     * Очистить все подписки
     */
    fun clearDisposables() {
        disposableBag.clear()
    }

    /**
     * Выполнить [Single] в io потоке, результат вернуть в main поток
     */
    fun <T> doAsyncSingle() = SingleTransformer { upstream: Single<T> ->
        upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun onCleared() {
        super.onCleared()
        clearDisposables()
    }

}