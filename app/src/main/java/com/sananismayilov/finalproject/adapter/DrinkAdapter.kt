package com.sananismayilov.finalproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.data.DrinkModel
import com.sananismayilov.finalproject.data.FoodModel
import com.sananismayilov.finalproject.data.FoodResponse
import com.sananismayilov.finalproject.databinding.DrinkrawBinding
import com.sananismayilov.finalproject.databinding.FoodrawBinding
import com.sananismayilov.finalproject.databinding.FragmentHomeBinding
import com.sananismayilov.finalproject.util.Util.BASE_URL
import com.sananismayilov.finalproject.util.Util.getImage

class DrinkAdapter(val drinklist: List<DrinkModel>) :
    RecyclerView.Adapter<DrinkAdapter.DrinkHolder>() {

    inner class DrinkHolder(val binding: DrinkrawBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkHolder {
        val binding = DataBindingUtil.inflate<DrinkrawBinding>(
            LayoutInflater.from(parent.context),
            R.layout.drinkraw, parent, false
        )

        return DrinkHolder(binding)
    }

    override fun getItemCount(): Int {
        return drinklist.size
    }

    override fun onBindViewHolder(holder: DrinkHolder, position: Int) {
        holder.binding.drink = drinklist[position]
        holder.binding.drinkimage.getImage("$BASE_URL//FinalProject/drinkimages/${drinklist.get(position).drink_image}")
    }


}