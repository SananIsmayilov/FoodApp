package com.sananismayilov.finalproject.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sananismayilov.finalproject.data.CartModel

@Dao
interface ProductDao {

    @Query("SELECT * FROM CartModel")
    suspend fun getProduct() : List<CartModel>

    @Insert
    suspend fun insertProduct(cartModel: CartModel)

    @Delete
    suspend fun deleteProduct(cartModel: CartModel)

    @Query("SELECT product_sale FROM CartModel")
    suspend fun getAllSales(): List<String>

    @Query("SELECT product_count FROM CartModel")
    suspend fun getAllCount(): List<Int>

    @Query("DELETE FROM CartModel")
    suspend fun deleteCart()

}