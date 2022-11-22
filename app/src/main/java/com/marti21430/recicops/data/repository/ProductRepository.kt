package com.marti21430.recicops.data.repository

import com.marti21430.recicops.data.model.Product
import java.util.*

interface ProductRepository {
    fun getProducts():List<Product>
    fun getProductsUser(username:String):List<Product>
    fun getProductUserDate(username:String, date: Date):List<Product>
}