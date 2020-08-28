package com.example.hulpjanrevive

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineDispatcher

class MainViewModelFactory(
    private val dispatcher: CoroutineDispatcher,
    private val context: Context,
    private val repository: MainRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(dispatcher, context, repository) as T
    }

}