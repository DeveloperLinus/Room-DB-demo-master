package com.itlong.room.demo2

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [FaceEntity::class, UserEntity::class], version = 4, exportSchema = true)
abstract class AppDatabase2 : RoomDatabase() {
    companion object {
        @Volatile
        private var instance: AppDatabase2? = null

        fun init(context: Context) {
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        fun getInstance(): AppDatabase2 {
            return instance ?: throw  NullPointerException("请先调用init方法初始化AppDataBase对象")
        }

        private fun buildDatabase(context: Context): AppDatabase2 {
            return Room.databaseBuilder(context, AppDatabase2::class.java, getDatabasePath())
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
//                .addMigrations(MIGRATION_1_2)
                .addMigrations(Migration_3_4)
//                .fallbackToDestructiveMigration() // 开发阶段，升级数据库直接抛弃数据
                .build()
        }

        private fun getDatabasePath(): String {
//            val sdExist = Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
//            return if (sdExist) {
//                val dbDir = Environment.getExternalStorageDirectory().absolutePath + "/mnt/data"
//                val dbPath = "$dbDir/demo2plugin.db"
//                val dirFile = File(dbDir)
//                if (!dirFile.exists()) dirFile.mkdirs()
//
//                Log.d("Room", "数据库路径: $dbPath")
//                dbPath
//            } else {
//                "demo2plugin.db"
//            }
            return "demo2plugin.db" // /data/data/com.itlong.room/databases
        }

        private val Migration_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "create table if not exists user2(id integer primary key autoincrement  not null" +
                            "account text not null" +
                            "password text not null);"
                )
            }
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "create table if not exists face(uid text primary key autoincrement  not null" +
                            "picPath text not null" +
                            "picUrl text not null);"
                )
            }
        }
    }

    abstract fun faceDao(): FaceDao
    abstract fun userDao(): UserDao
}