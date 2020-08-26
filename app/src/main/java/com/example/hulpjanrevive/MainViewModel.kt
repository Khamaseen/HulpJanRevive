package com.example.hulpjanrevive

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val repository: MainRepository
): ViewModel() {

    private val tasks: MutableLiveData<Int> = MutableLiveData<Int>()
    val liveTasks: LiveData<Int> = tasks

    companion object {

    }

    init {

    }

}