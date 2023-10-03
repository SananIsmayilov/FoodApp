package com.sananismayilov.finalproject.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.sananismayilov.finalproject.R

object Util {

    fun Navigation.getNav(view : View , id : Int){
        Navigation.findNavController(view).navigate(id)
    }


    fun ImageView.getImage(imagelink : String){
        Glide
            .with(this)
            .load(imagelink)
            .error(R.drawable.backfood)
            .into(this)
    }

    const val BASE_URL = "https://sananismayilov.000webhostapp.com"
    const val PrefName = "UserStatus"
}