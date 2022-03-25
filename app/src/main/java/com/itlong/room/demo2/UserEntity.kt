package com.itlong.room.demo2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user2")
data class UserEntity(var account: String, var password: String) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}