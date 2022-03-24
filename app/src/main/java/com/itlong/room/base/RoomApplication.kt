package com.itlong.room.base

import android.app.Application
import android.content.Context

class RoomApplication : Application() {
    companion object {
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}