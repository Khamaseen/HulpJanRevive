package com.example.hulpjanrevive.data

import android.content.Context
import androidx.work.*
import kotlinx.coroutines.coroutineScope

class UpdateDBWorker(
    private val inputKey: String,
    private val listToUpdate: ArrayList<String>?,
    private val outputKey: String
) {

    fun buildOneTimeRequestWorker(): OneTimeWorkRequest {
        return OneTimeWorkRequestBuilder<Worker>().apply {
            listToUpdate?.let {
                this.setInputData(
                    Data.Builder().putStringArray(inputKey, listToUpdate.toTypedArray()).build()
                )
            }
        }.build()
    }

    private inner class Worker(
        context: Context,
        parameters: WorkerParameters
    ) : CoroutineWorker(context, parameters) {

        override suspend fun doWork(): Result = coroutineScope {
            val inputData = inputData.getStringArray(inputKey)

            try {
                //fake output
                val data = Data.Builder()
                    .putStringArray(outputKey, ArrayList<String>().toTypedArray())
                    .build()
                Result.success(data)
            } catch (exception: Exception) {
                Result.failure()
            }
        }

    }

}