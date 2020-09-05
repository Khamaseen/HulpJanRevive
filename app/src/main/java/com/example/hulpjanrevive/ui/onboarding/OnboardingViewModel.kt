package com.example.hulpjanrevive.ui.onboarding

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hulpjanrevive.data.entities.Association
import com.example.hulpjanrevive.data.entities.User
import com.example.hulpjanrevive.data.repositories.OnboardingRepository
import com.example.hulpjanrevive.ui.RawIconResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val onboardingRepository: OnboardingRepository
): ViewModel() {

    val _isInserted: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isInserted: LiveData<Boolean> = _isInserted

    fun insertUser(name: String, association: Association, image: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val listLong: List<Long> = onboardingRepository.insertNewUser(User(name, association,
                RawIconResource(image), true))
            _isInserted.value = ! listLong.isNullOrEmpty()
        }
    }


}