package com.marti21430.recicops.data.dao

import androidx.room.*
import com.marti21430.recicops.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getUsers(): List<User>

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Update
    suspend fun update(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User): Int

    @Query("DELETE FROM user")
    suspend fun deleteAll(): Int

}