package com.sananismayilov.finalproject.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class CartModel(
    @PrimaryKey(autoGenerate = true)
    val product_id: Int,

    @ColumnInfo("product_name")
    val product_name: String,

    @ColumnInfo("product_image")
    val product_image: String,

    @ColumnInfo("product_sale")
    val product_sale: String,

    @ColumnInfo("product_count")
    val product_count: Int,



    )
