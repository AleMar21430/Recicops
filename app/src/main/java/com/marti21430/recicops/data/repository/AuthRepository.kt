package com.marti21430.recicops.data.repository

import com.google.firebase.auth.FirebaseUser
import com.marti21430.recicops.data.Resource

interface AuthRepository{
    suspend fun signInWithEmailAndPassword(email: String, password: String) : String?
    suspend fun signUpWithEmailPasswordName(email:String,password: String):String?
}
