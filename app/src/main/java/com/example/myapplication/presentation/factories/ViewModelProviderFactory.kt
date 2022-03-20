package com.example.myapplication.presentation.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlin.reflect.KClass

inline fun <reified VM : ViewModel> ViewModelStoreOwner.viewModelFactory(
    noinline creator: (() -> VM),
    noinline callback: ((VM) -> Unit)? = null
) = viewModelFactory(VM::class, creator, callback)

fun <VM : ViewModel> ViewModelStoreOwner.viewModelFactory(
    clazz: KClass<VM>,
    creator: (() -> VM),
    callback: ((VM) -> Unit)? = null
) = ViewModelLazy(
    clazz,
    { viewModelStore },
    { ViewModelProviderFactory(creator, callback) }
)

class ViewModelProviderFactory<VM : ViewModel>(
    private val creator: () -> VM,
    private val callback: ((VM) -> Unit)? = null
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return (creator.invoke() as T).apply {
            callback?.invoke(this as VM)
        }
    }
}