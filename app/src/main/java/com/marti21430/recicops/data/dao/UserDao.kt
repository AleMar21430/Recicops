package com.marti21430.recicops.data.dao

import androidx.room.Dao
import androidx.room.Delete

@Dao
interface UserDao {
    @Delete
    suspend fun deleteHistoric()
}