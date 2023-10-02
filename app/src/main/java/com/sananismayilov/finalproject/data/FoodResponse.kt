package com.sananismayilov.finalproject.data

import com.google.gson.annotations.SerializedName

data class FoodResponse(
    @SerializedName("Food")
    val foodlist: List<FoodModel>,

    @SerializedName("success")
    val success: Int


)