package com.briapps.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel: ViewModel(), CoroutineScope by CoroutineScope(SupervisorJob() + Dispatchers.Main) {

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancelChildren()
        coroutineContext.cancel()
    }
}