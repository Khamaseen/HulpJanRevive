package com.example.hulpjanrevive.data


interface MainRepository {

    fun returnMockTasks(): List<Int>
    fun addToMock(number: Int)

}