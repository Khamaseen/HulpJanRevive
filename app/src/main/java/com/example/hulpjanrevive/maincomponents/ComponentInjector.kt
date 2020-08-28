package com.example.hulpjanrevive.maincomponents

import android.content.Context
import com.example.hulpjanrevive.ui.MainViewModelFactory
import com.example.hulpjanrevive.data.PersonRepositoryImpl
import com.example.hulpjanrevive.ui.PersonViewModelFactory
import com.example.hulpjanrevive.data.MainRepositoryImpl
import kotlinx.coroutines.Dispatchers

object ComponentInjector {

    fun provideMainViewModelFactory(context: Context): MainViewModelFactory {
        return MainViewModelFactory(
            Dispatchers.IO, context,
            MainRepositoryImpl()
        )
    }

    fun providePersonViewModelFactory(context: Context): PersonViewModelFactory {
        return PersonViewModelFactory(
            Dispatchers.IO,
            context,
            PersonRepositoryImpl()
        )
    }

}