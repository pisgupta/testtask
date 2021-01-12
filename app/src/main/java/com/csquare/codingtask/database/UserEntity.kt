package com.csquare.codingtask.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_user")
data class UserEntity(
    @PrimaryKey var id: Int,
    @NonNull @ColumnInfo(name = "email") val email: String?,
    @NonNull @ColumnInfo(name = "first_name") val first_name: String?,
    @NonNull @ColumnInfo(name = "last_name") val last_name: String?,
    @NonNull @ColumnInfo(name = "avatar") val avatar: String?
)
