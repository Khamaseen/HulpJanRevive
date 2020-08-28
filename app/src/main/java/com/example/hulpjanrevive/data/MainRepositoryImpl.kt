package com.example.hulpjanrevive.data

class MainRepositoryImpl(

): MainRepository {

    companion object {
        private val mockListOfInt = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 87, 65, 3)
    }

    override fun returnMockTasks(): List<Int> {
        return mockListOfInt
    }

    override fun addToMock(number: Int) {
        mockListOfInt.add(number)
    }

}