package com.example.hulpjanrevive.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.data.util.ResourceMapper
import kotlinx.coroutines.CoroutineDispatcher

class PersonViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val context: Context,
    private val personRepository: PersonRepository
) : ViewModel() {

    //THIS MAPPER SHOULD BE IN DATA
    private val resourceMapper: ResourceMapper = ResourceMapper()
    private val listRawIcons: List<RawIconResource> = listOf<RawIconResource>(
        RawIconResource(0),
        RawIconResource(1),
        RawIconResource(2),
        RawIconResource(3)
    )

    private val _editMode: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private val _name: MutableLiveData<String> = MutableLiveData<String>()
    private val _listAvatars: MutableLiveData<List<IconResource>> =
        MutableLiveData<List<IconResource>>()
    private val _avatar: MutableLiveData<IconResource> = MutableLiveData<IconResource>()
    //TODO() list tasks

    val listAvatars: LiveData<List<IconResource>> = _listAvatars
    val editMode: LiveData<Boolean> = _editMode
    val name: LiveData<String> = _name
    val avatar: LiveData<IconResource> = _avatar
    //TODO() list tasks

    init {
        _editMode.value = false
    }

    fun switchEditMode() {
        _editMode.value = !(editMode.value as Boolean)
    }

    fun updateProfile(name: String) {
        _name.value = name
    }

    fun getMockAvatars() {
        _listAvatars.value = resourceMapper.mapToIconResources(listRawIcons)
    }

    fun postAvatar() {
        _avatar.value = IconResource(R.drawable.ic_default_profile, R.string.ic_default_profile)
    }

}