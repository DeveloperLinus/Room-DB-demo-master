package com.itlong.room.demo2


object UserManager {
    private val dao by lazy {
        AppDatabase2.getInstance().userDao()
    }

    fun insert(user: UserEntity): Long {
        return dao.insert(user)
    }
}