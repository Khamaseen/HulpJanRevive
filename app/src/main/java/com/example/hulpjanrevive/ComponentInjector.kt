package com.example.hulpjanrevive

import android.content.Context

object ComponentInjector {

    fun provideMainViewModelFactory(context: Context): FactoryMainViewModel {
        return FactoryMainViewModel(MainRepositoryImpl())
    }


}