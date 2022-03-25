package com.itlong.room.base

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object AppExecutors {
    val WORK_IO:Executor by lazy {
        Executors.newFixedThreadPool(10)
    }

    val MAIN: Executor by lazy { MainThreadExecutor()}

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}