package com.example.hulpjanrevive

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher

class PersonViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val context: Context,
    private val personRepository: PersonRepository
): ViewModel() {



}