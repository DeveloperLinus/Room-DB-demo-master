package com.itlong.room.demo2

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

abstract class AppDatabase  : RoomDatabase() {
    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun init(context: Context) {
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, getDatabasePath())
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.d("Room", "数据库已创建")
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        Log.d("Room", "数据库已打开")
                    }
                })
                .allowMainThreadQueries()
                .build()
        }

        private fun getDatabasePath() : String {
            return "face.db"
        }
    }
}