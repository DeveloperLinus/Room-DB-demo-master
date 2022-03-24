package com.itlong.room.demo2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: FaceEntity):Long

    @Query("select * from face where uid=:uid limit 1")
    fun queryByUid(uid: String): FaceEntity?

    @Query("delete from face where uid = :uid")
    fun delete(uid: String)
}