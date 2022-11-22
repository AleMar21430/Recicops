package com.marti21430.recicops.data.remote.firestore

import com.marti21430.recicops.data.Resource
import com.marti21430.recicops.data.remote.api.AuthApi
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class FirestoreAuthApiImpl(
    private val api: FirebaseAuth
) : AuthApi {
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Resource<String> {
        return try {
            val response = api.signInWithEmailAndPassword(email, password).await()

            val user = response.user
            if (user != null)
                Resource.Success(data = user.uid)
            else
                Resource.Error(message = "User not found")
        } catch (e: Exception) {
            Resource.Error(message = "User not found")
        }
    }
}