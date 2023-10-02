package com.sananismayilov.finalproject.data

import com.google.gson.annotations.SerializedName

data class FoodModel(
    @SerializedName("food_id")
    val food_id: String,

    @SerializedName("food_name")
    val food_name: String,

    @SerializedName("food_sale")
    val food_sale: String,

    @SerializedName("food_description")
    val food_description: String,

    @SerializedName("food_image")
    val food_image: String,

    )