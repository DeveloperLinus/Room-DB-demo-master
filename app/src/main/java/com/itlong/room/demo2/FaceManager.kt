package com.itlong.room.demo2

object FaceManager {
    private val dao by lazy {
        AppDatabase2.getInstance().faceDao()
    }

    fun queryByUid(uid: String) : FaceEntity? {
        return dao.queryByUid(uid = uid)
    }

    fun deleteByUid(uid: String) {
        dao.delete(uid)
    }

    fun insertOrReplace(entity: FaceEntity): Long {
        return dao.insert(entity)
    }
}