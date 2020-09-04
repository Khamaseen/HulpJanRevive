package com.example.hulpjanrevive.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hulpjanrevive.ui.RawIconResource

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val name: String,
    val association: Association,
    @ColumnInfo(name = "icon_resource") val rawIconResource: RawIconResource,
    @ColumnInfo(name = "is_self") val isSelf: Boolean
) {
}

enum class Association {
    FAMILY, NEIGHBOUR, CARE_GIVER, FRIEND
}