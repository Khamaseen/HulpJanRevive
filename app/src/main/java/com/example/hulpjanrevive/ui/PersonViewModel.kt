package com.example.hulpjanrevive.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.hulpjanrevive.data.PersonRepository
import kotlinx.coroutines.CoroutineDispatcher

class PersonViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val context: Context,
    private val personRepository: PersonRepository
): ViewModel() {



}