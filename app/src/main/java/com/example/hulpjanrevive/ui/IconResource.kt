package com.example.hulpjanrevive.ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IconResource(
    val icon: Int,
    val description: Int
) : Parcelable