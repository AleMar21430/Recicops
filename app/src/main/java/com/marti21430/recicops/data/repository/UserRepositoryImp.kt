package com.marti21430.recicops.data.repository

import com.marti21430.recicops.data.model.User

class UserRepositoryImp:UserRepository {
    override fun getUsers(): List<User> {
        return arrayListOf()
    }

    override fun getUser(email:String,password:String): User {
        var listUser = getUsers()
        for (item in listUser){
            if (item.email.equals(email) && item.password.equals(password)){
                return item
            }
        }
        return null!!
    }
}