package com.marti21430.recicops.data.remote.api

import com.marti21430.recicops.data.Resource

interface AuthApi {
    suspend fun signInWithEmailAndPassword(email: String, password: String) : Resource<String>
    suspend fun signUpWithEmailAndPassword(email: String, password: String) : Resource<String>
}