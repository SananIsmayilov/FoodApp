package com.sananismayilov.finalproject.data

import com.google.gson.annotations.SerializedName

data class CrudResponse  ( @SerializedName("success" ) var success : Int?    = null,
                           @SerializedName("message" ) var message : String? = null)