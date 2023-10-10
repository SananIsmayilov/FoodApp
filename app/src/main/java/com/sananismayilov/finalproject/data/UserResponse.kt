package com.sananismayilov.finalproject.data

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("User")
    val userlist : List<User>,

    @SerializedName("success")
    val success : Int
)