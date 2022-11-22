package com.marti21430.recicops.data.repository

import com.marti21430.recicops.data.model.User

interface UserRepository {
    fun getUsers():List<User>
    fun getUser(email:String,password:String):User
}