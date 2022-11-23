package com.marti21430.recicops.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marti21430.recicops.data.model.User

@Database(entities = [User::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun userDao(): UserDao
}