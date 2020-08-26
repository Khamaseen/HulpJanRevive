package com.example.hulpjanrevive

interface MainRepository {

    fun returnMockTasks(): List<Int>
    fun addToMock(number: Int)
}