package com.marti21430.recicops.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Product(
    val id: Int,
    val username:String,
    val name:String,
    val amount: Int,
    val category: String,
    @ServerTimestamp
    val date: Date
)
