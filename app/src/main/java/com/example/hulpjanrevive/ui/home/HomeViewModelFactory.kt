package com.example.hulpjanrevive.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hulpjanrevive.data.MainRepository
import kotlinx.coroutines.CoroutineDispatcher

class HomeViewModelFactory(
    private val dispatcher: CoroutineDispatcher,
    private val context: Context,
    private val repository: MainRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(
            dispatcher,
            context,
            repository
        ) as T
    }

}