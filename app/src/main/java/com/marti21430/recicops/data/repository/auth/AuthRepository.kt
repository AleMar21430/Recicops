package com.marti21430.recicops.data.repository.auth

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String) : String?
}