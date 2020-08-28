package com.example.hulpjanrevive

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val context: Context,
    private val repository: MainRepository
) : ViewModel() {

    private val tasks: MutableLiveData<List<Int>> = MutableLiveData<List<Int>>()
    val liveTasks: LiveData<List<Int>> = tasks

    companion object {

    }

    init {
        getList()

    }

    fun addNumber() {
        repository.addToMock(331)
        getList()
    }

    private fun getList() {
        viewModelScope.launch(dispatcher) {
            tasks.postValue(repository.returnMockTasks())
        }
    }

    fun simple(): Flow<Int> = flow { // flow builder
        for (i in 1..3) {
            delay(100) // pretend we are doing something useful here
            emit(i) // emit next value
        }
    }

}