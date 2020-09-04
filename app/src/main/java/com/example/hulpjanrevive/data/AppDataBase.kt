package com.example.hulpjanrevive.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.hulpjanrevive.data.dao.UsersDao
import com.example.hulpjanrevive.data.entities.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        private const val DATABASE_NAME = "only jan"

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        //This database should, with the callback, after getting an instance be updated.
        //If things go well... microservices...
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).addCallback(object: RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val work = OneTimeWorkRequestBuilder<DatabaseWorker>().build()
                    WorkManager.getInstance(context).enqueue(work)
                }
            }).build()
        }
    }

}
