package com.example.hulpjanrevive.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hulpjanrevive.data.entities.User

@Dao
interface UsersDao {

    @Query("SELECT * FROM users")
    suspend fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
    suspend fun findByName(name: String): LiveData<User>

    @Insert
    suspend fun insertUser(vararg users: User)

    @Update
    suspend fun updateUsers(vararg users: User)

    @Delete
    suspend fun deleteUser(vararg user: User)

}