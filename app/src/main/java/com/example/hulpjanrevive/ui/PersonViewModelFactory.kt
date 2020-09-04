package com.example.hulpjanrevive.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineDispatcher

class PersonViewModelFactory(
    private val dispatcher: CoroutineDispatcher,
    private val context: Context
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonViewModel(
            dispatcher,
            context
        ) as T
    }

}