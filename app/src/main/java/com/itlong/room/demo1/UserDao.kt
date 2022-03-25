package com.itlong.room.demo1

import androidx.room.*

// 数据访问对象（DAO）
@Dao
interface UserDao {
    @Query("select *  from user where uid = :uid")
    fun query(uid: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("delete from user where uid = :uid")
    fun delete(uid: Int)
}