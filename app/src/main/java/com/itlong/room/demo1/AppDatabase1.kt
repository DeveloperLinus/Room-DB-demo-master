package com.itlong.room.demo1

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.itlong.room.base.RoomApplication
import java.lang.NullPointerException

// 数据库

@Database(entities = [User::class], version = 1)
abstract class AppDatabase1 : RoomDatabase() {
    companion object {
        private var instance: AppDatabase1? = null
        fun init(context: Context) {
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
                        .also { instance = it }
            }
        }

        fun getInstance(): AppDatabase1 {
            return instance?: throw  NullPointerException("请先调用init方法初始化AppDataBase对象")
        }

        private fun buildDatabase(context: Context): AppDatabase1 {
            return Room.databaseBuilder(
                context,
                AppDatabase1::class.java, "userplugin")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.d("Room", "userplugin数据库已创建")
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        Log.d("Room", "userplugin数据库已打开")
                    }
                })
                .allowMainThreadQueries()
                .build()
        }
    }
    abstract fun userDao(): UserDao
}