package com.marti21430.recicops.data.repository

import com.marti21430.recicops.data.model.Product
import java.util.*

class ProductRepositoryImp:ProductRepository {
    override fun getProducts(): List<Product> {
        return arrayListOf()
    }

    override fun getProductsUser(username: String): List<Product> {
        TODO("Not yet implemented")
    }

    override fun getProductUserDate(username: String, date: Date): List<Product> {
        TODO("Not yet implemented")
    }
}