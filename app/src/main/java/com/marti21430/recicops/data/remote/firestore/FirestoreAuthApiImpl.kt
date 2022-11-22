package com.marti21430.recicops.data.remote.firestore

import com.google.firebase.auth.FirebaseAuth
import com.marti21430.recicops.data.Resource
import com.marti21430.recicops.data.remote.api.AuthApi
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
                Resource.Success(result = user.uid)
            else
                Resource.Failure(exception = "No se encontro el usuario")
        } catch (e: Exception) {
            Resource.Failure(exception = "No se encontro al usuario")
        }
    }

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Resource<String> {
        return try {
            val response = api.createUserWithEmailAndPassword(email, password).await()

            val user = response.user
            if (user != null)
                Resource.Success(result = user.uid)
            else
                Resource.Failure(exception = "No se encontro el usuario")
        } catch (e: Exception) {
            Resource.Failure(exception = "No se encontro al usuario")
        }
    }

}