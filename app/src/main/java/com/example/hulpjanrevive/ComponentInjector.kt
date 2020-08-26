package com.example.hulpjanrevive

import android.content.Context
import kotlinx.coroutines.Dispatchers

object ComponentInjector {

    fun provideMainViewModelFactory(context: Context): FactoryMainViewModel {
        return FactoryMainViewModel(Dispatchers.IO, MainRepositoryImpl())
    }


}