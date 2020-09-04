package com.example.hulpjanrevive.data

import android.content.Context
import androidx.work.*


//TODO() Last point of DBSync should be implemented in sharedPref
//TODO() WARNING: what happens if the action of updating is killed before finalizing? -> Should be some SQLIte solution, not?
class SyncDatabaseWorker(
    private val context: Context,
    private val lastUpdate: String
) {

    companion object {
        const val KEY_DB_INIT = "init db hulpjan"

        private const val KEY_IN_RETRIEVE = "retrieve"
        private const val KEY_SYNC = "sync"

        const val KEY_END = "end"
    }

    fun sync() {
        val retrieveWorker = RetrieveUpdatesWorker(KEY_IN_RETRIEVE, lastUpdate, KEY_SYNC).buildOneTimeRequestWorker()
        val updateWorker = UpdateDBWorker(KEY_SYNC, null, KEY_END).buildOneTimeRequestWorker()

        WorkManager.getInstance(context)
            .beginUniqueWork(
                KEY_DB_INIT,
                ExistingWorkPolicy.KEEP,
                retrieveWorker)
            .then(updateWorker)
            .enqueue()
    }

}