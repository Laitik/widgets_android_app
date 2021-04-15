package com.example.myapplication.helper

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class ViewModelScope :  ViewModel(), CoroutineScope {
    final override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + parentJob
    protected val parentJob = SupervisorJob()
    val scope = CoroutineScope(coroutineContext)
}