package com.marti21430.recicops.data

import java.lang.Exception

sealed class Resource<out R>{
    data class Success<out R>(val result:R): Resource<R>()
    data class Failure(val exception:String): Resource<Nothing>()
    object Loading: Resource<Nothing>()
}