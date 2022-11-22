package com.marti21430.recicops.ui.core

import androidx.lifecycle.ViewModel
import com.marti21430.recicops.data.model.User
import com.marti21430.recicops.data.repository.UserRepository

class UserViewModel (
    val repository: UserRepository
        ):ViewModel(){
    fun getUsers(): List<User>{
        return repository.getUsers()
    }
    fun getUser(username:String,password:String):User{
        return repository.getUser(username, password)
    }

}