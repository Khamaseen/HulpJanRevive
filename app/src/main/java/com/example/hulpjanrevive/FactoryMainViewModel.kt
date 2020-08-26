package com.example.hulpjanrevive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FactoryMainViewModel(
    private val repository: MainRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}