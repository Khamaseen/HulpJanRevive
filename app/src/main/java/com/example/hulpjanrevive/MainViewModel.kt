package com.example.hulpjanrevive

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val repository: MainRepository
) : ViewModel() {

    private val tasks: MutableLiveData<List<Int>> = MutableLiveData<List<Int>>()
    val liveTasks: LiveData<List<Int>> = tasks

    companion object {

    }

    init {
        viewModelScope.launch(dispatcher) {
            tasks.postValue(repository.returnMockTasks())
        }
    }

}