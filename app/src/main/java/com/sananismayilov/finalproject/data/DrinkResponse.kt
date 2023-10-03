package com.sananismayilov.finalproject.data

import com.google.gson.annotations.SerializedName

data class DrinkResponse(
    @SerializedName("Drink")
    val drinks: List<DrinkModel>,

    @SerializedName("success")
    val success: Int
)
