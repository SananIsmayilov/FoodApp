package com.sananismayilov.finalproject.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DrinkModel(
    @SerializedName("drink_id")
    val drink_id: String,

    @SerializedName("drink_name")
    val drink_name: String,

    @SerializedName("drink_sale")
    val drink_sale: String,

    @SerializedName("drink_description")
    val drink_description: String,

    @SerializedName("drink_image")
    val drink_image: String

) : Serializable
