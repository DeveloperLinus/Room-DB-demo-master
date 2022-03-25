package com.itlong.room.demo1

object UserManager {
    private val dao by lazy {
        AppDatabase1.getInstance().userDao()
    }

    fun insert(user: User) {
        dao.insert(user)
    }

    fun delete(uid: Int) {
        dao.delete(uid)
    }

    fun query(uid: Int): User? {
        return dao.query(uid)
    }
}