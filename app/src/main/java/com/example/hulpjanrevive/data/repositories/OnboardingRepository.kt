package com.example.hulpjanrevive.data.repositories

import com.example.hulpjanrevive.data.dao.UsersDao
import com.example.hulpjanrevive.data.entities.User

class OnboardingRepository private constructor(
    private val usersDao: UsersDao
) {

    companion object {

        @Volatile
        private var instance: OnboardingRepository? = null

        fun getInstance(usersDao: UsersDao) =
            instance ?: synchronized(this) {
                instance ?: OnboardingRepository(usersDao).also { instance = it }
            }
    }

    suspend fun insertNewUser(user: User): List<Long> {
        return usersDao.insertUser(user)
    }

}