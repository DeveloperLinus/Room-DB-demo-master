package com.itlong.room.demo2

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    fun insert(user: UserEntity): Long
}