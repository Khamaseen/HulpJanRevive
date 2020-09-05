package com.example.hulpjanrevive.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hulpjanrevive.data.repositories.OnboardingRepository

class OnboardingViewModelFactory(
    private val onboardingRepository: OnboardingRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OnboardingViewModel(onboardingRepository) as T
    }

}