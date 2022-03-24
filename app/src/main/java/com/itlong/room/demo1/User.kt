package com.itlong.room.demo1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 数据实体
@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)