package com.example.hulpjanrevive.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hulpjanrevive.data.entities.User

@Dao
interface UsersDao {

    @Query("SELECT * FROM users WHERE is_self LIMIT 1")
    suspend fun getSelf(): LiveData<User>

    @Query("SELECT * FROM users")
    suspend fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
    suspend fun findByName(name: String): LiveData<User>

    @Insert
    suspend fun insertUser(vararg users: User): List<Long>

    @Update
    suspend fun updateUsers(vararg users: User): List<Long>

    @Delete
    suspend fun deleteUser(vararg user: User): List<Long>

}