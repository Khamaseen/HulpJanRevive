package com.example.hulpjanrevive.data


import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope


class DatabaseWorker(
    context: Context,
    parameters: WorkerParameters
) : CoroutineWorker(context, parameters) {

    companion object {
        private const val DATABASE_INIT = "init db hulpjan"
    }

    override suspend fun doWork(): Result = coroutineScope{
        //TODO() Retrieve recent updates and sync these with the DATABASE
        //Should work with microservices (eventually)

        try {
            Result.success()
        } catch (exception: Exception) {
            Result.failure()
        }
    }

}