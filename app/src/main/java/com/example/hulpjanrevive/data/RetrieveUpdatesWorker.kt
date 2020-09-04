package com.example.hulpjanrevive.data


import android.content.Context
import androidx.work.*
import kotlinx.coroutines.coroutineScope


class RetrieveUpdatesWorker(
    private val inputKey: String,
    private val retrieveFromPoint: String,
    private val outputKey: String
) {

    fun buildOneTimeRequestWorker(): OneTimeWorkRequest {
        return OneTimeWorkRequestBuilder<Worker>().apply {
            retrieveFromPoint.let {
                this.setInputData(
                    Data.Builder().putString(inputKey, retrieveFromPoint).build()
                )
            }
        }.build()
    }

    private inner class Worker(
        context: Context,
        parameters: WorkerParameters
    ) : CoroutineWorker(context, parameters) {

        override suspend fun doWork(): Result = coroutineScope {

            try {
                val inputData = inputData.getString(inputKey)
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