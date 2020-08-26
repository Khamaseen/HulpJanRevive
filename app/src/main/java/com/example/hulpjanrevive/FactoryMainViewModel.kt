package com.example.hulpjanrevive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineDispatcher

class FactoryMainViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val repository: MainRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(dispatcher, repository) as T
    }

}