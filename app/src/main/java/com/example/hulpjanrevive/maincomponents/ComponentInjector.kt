package com.example.hulpjanrevive.maincomponents

import android.content.Context
import com.example.hulpjanrevive.data.AppDatabase
import com.example.hulpjanrevive.data.MainRepositoryImpl
import com.example.hulpjanrevive.data.repositories.OnboardingRepository
import com.example.hulpjanrevive.ui.home.HomeViewModelFactory
import com.example.hulpjanrevive.ui.onboarding.OnboardingViewModelFactory
import com.example.hulpjanrevive.ui.person.PersonViewModelFactory
import kotlinx.coroutines.Dispatchers

object ComponentInjector {

    fun provideMainViewModelFactory(context: Context): HomeViewModelFactory {
        return HomeViewModelFactory(
            Dispatchers.IO, context,
            MainRepositoryImpl()
        )
    }

    fun providePersonViewModelFactory(context: Context): PersonViewModelFactory {
        return PersonViewModelFactory(
            Dispatchers.IO,
            context
        )
    }

    fun provideOnboardingViewModelFactory(context: Context): OnboardingViewModelFactory {
        return OnboardingViewModelFactory(getOnboardingRepository(context))
    }

    private fun getOnboardingRepository(context: Context): OnboardingRepository {
        return OnboardingRepository.getInstance(AppDatabase.getInstance(context).usersDao())
    }

}