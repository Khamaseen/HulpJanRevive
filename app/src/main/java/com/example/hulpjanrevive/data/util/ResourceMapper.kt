package com.example.hulpjanrevive.data.util

import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.ui.IconResource
import com.example.hulpjanrevive.ui.RawIconResource

class ResourceMapper(

) {

    companion object {
        private const val DEFAULT = 0
        private const val DEFAULT_2 = 1
        private const val DEFAULT_3 = 2
        private const val DEFAULT_4 = 3
    }

    fun mapToIconResources(list: List<RawIconResource>): List<IconResource> {
        return list.map { number -> getIconResource(number.iconNumber) }
    }

    fun mapToRawIconResource(list: List<IconResource>): List<RawIconResource> {
        return list.map { iconResource -> getRawIconResource(iconResource.icon)  }
    }

    private fun getIconResource(number: Int): IconResource {
        return when(number) {
            DEFAULT -> IconResource(R.drawable.ic_default_profile, R.string.ic_default_profile)
            DEFAULT_2 -> IconResource(R.drawable.ic_default_profile_2, R.string.ic_default_profile_2)
            DEFAULT_3 -> IconResource(R.drawable.ic_default_profile_3, R.string.ic_default_profile_3)
            DEFAULT_4 -> IconResource(R.drawable.ic_default_profile_4, R.string.ic_default_profile_4)
            else -> IconResource(R.drawable.ic_default_profile, R.string.ic_default_profile)
        }
    }

    private fun getRawIconResource(resource: Int): RawIconResource {
        return when(resource) {
            R.drawable.ic_default_profile -> RawIconResource(DEFAULT)
            R.drawable.ic_default_profile_2 -> RawIconResource(DEFAULT_2)
            R.drawable.ic_default_profile_3 -> RawIconResource(DEFAULT_3)
            R.drawable.ic_default_profile_4 -> RawIconResource(DEFAULT_4)
            else -> RawIconResource(DEFAULT)
        }
    }

}