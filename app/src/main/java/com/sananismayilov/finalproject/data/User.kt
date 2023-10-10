package com.sananismayilov.finalproject.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user_password")
    val user_password : String,

    @SerializedName("user_phonenumber")
    val user_phonenumber : String,


)
