package com.example.hulpjanrevive

import android.content.Context
import kotlinx.coroutines.Dispatchers

object ComponentInjector {

    fun provideMainViewModelFactory(context: Context): MainViewModelFactory {
        return MainViewModelFactory(Dispatchers.IO, context, MainRepositoryImpl())
    }

    fun providePersonViewModelFactory(context: Context): PersonViewModelFactory {
        return PersonViewModelFactory(Dispatchers.IO, context, PersonRepositoryImpl())
    }

}