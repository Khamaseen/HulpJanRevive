package com.example.hulpjanrevive.data

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.hulpjanrevive.BuildConfig


//TODO() Last point of DBSync should be implemented in sharedPref
//TODO() WARNING: what happens if the action of updating is killed before finalizing? -> Should be some SQLIte solution, not?
class SyncDatabaseWorker(
    private val context: Context
) {

    companion object {
        const val KEY_DB_INIT = "init db hulpjan"

        private const val KEY_IN_RETRIEVE = "retrieve"
        private const val KEY_SYNC = "sync"
        private const val SHARED_PREFERENCES_LAST_UPDATE = "last_update_pref"
        private const val SHARED_PREF_KEY_LAST_UPDATE = "key_last_update"

        const val KEY_END = "end"
    }

    fun sync() {
        val retrieveWorker = RetrieveUpdatesWorker(
            KEY_IN_RETRIEVE,
            getLastUpdateAsString(),
            KEY_SYNC
        ).buildOneTimeRequestWorker()
        val updateWorker = UpdateDBWorker(KEY_SYNC, null, KEY_END).buildOneTimeRequestWorker()

        WorkManager.getInstance(context)
            .beginUniqueWork(
                KEY_DB_INIT,
                ExistingWorkPolicy.KEEP,
                retrieveWorker
            )
            .then(updateWorker)
            .enqueue()
    }

    private fun getLastUpdateAsString(): String {
        val sharedPreferencesName = BuildConfig.APPLICATION_ID + SHARED_PREFERENCES_LAST_UPDATE
        val sharedPreferences =
            context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)
        return sharedPreferences.getLong(SHARED_PREF_KEY_LAST_UPDATE, 0).let {
            if (it == 0L) {
                ""
            } else {
                it.toString()
            }
        }
    }

}