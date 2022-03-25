package com.itlong.room.base

import android.app.Application
import android.content.Context
import com.itlong.room.demo1.AppDatabase1
import com.itlong.room.demo2.AppDatabase2

class RoomApplication : Application() {
    companion object {
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = this
        // 初始化数据库
        AppDatabase2.init(this)
        AppDatabase1.init(this)
    }
}