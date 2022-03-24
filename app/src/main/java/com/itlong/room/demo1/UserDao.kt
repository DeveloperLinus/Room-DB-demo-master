package com.itlong.room.demo1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

// 数据访问对象（DAO）
@Dao
interface UserDao {
    @Query("select * from user")
    fun getAll(): List<User>

    @Query("select * from user where uid in (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("select *  from user where first_name like :first and last_name like :last limit 1")
    fun findByName(first: String, last:String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}