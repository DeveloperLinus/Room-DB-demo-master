package com.itlong.room.demo2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "face")
data class FaceEntity(
    @PrimaryKey
    var uid: String,
    var picPath: String,
    var picUrl: String
)