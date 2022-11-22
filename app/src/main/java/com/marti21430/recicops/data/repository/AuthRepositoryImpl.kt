package com.marti21430.recicops.data.repository

import com.marti21430.recicops.data.Resource
import com.marti21430.recicops.data.remote.api.AuthApi

class AuthRepositoryImpl (
        private val authApi: AuthApi
        ):AuthRepository{
        override suspend fun signInWithEmailAndPassword(email: String, password: String): String? {
                val authResponse = authApi.signInWithEmailAndPassword(email, password)

                return if (authResponse is Resource.Success)
                        authResponse.result!!
                else
                        null
        }

        override suspend fun signUpWithEmailPasswordName(
                email: String,
                password: String
        ): String? {
                val authResponse = authApi.signUpWithEmailAndPassword(email, password)

                return if (authResponse is Resource.Success)
                        authResponse.result!!
                else
                        null
        }
}


