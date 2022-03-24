package com.itlong.room.demo1

import androidx.room.Room
import com.itlong.room.base.RoomApplication


object AppDatabaseManager {
    val db = Room.databaseBuilder(RoomApplication.context,
    AppDatabase::class.java, "db_demo1")
        .build()
}