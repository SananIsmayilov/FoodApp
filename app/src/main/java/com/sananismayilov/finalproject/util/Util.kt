package com.sananismayilov.finalproject.util

import android.view.View
import androidx.navigation.Navigation

object Util {

    fun Navigation.getNav(view : View , id : Int){
        Navigation.findNavController(view).navigate(id)
    }
}