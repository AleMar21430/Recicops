package com.marti21430.recicops.di

import com.marti21430.recicops.data.remote.api.AuthApi
import com.marti21430.recicops.data.remote.api.PlaceApi
import com.marti21430.recicops.data.remote.firestore.FirestoreAuthApiImpl
import com.marti21430.recicops.data.remote.firestore.FirestorePlaceApiImpl
import com.marti21430.recicops.data.repository.auth.AuthRepository
import com.marti21430.recicops.data.repository.auth.AuthRepositoryImpl
import com.marti21430.recicops.data.repository.place.PlaceRepository
import com.marti21430.recicops.data.repository.place.PlaceRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthProvider() : FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun provideAuthApi(auth: FirebaseAuth) : AuthApi = FirestoreAuthApiImpl(auth)

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi) : AuthRepository = AuthRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideApiProvider(): FirebaseFirestore = Firebase.firestore

    @Provides
    @Singleton
    fun providePlaceApi(db: FirebaseFirestore): PlaceApi = FirestorePlaceApiImpl(db)

    @Provides
    @Singleton
    fun providePlaceRepository(api: PlaceApi) : PlaceRepository = PlaceRepositoryImpl(api)

}