package com.itlong.room.demo1

import androidx.room.Database
import androidx.room.RoomDatabase

// 数据库

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}