package com.sananismayilov.finalproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.data.FoodModel
import com.sananismayilov.finalproject.data.FoodResponse
import com.sananismayilov.finalproject.databinding.FoodrawBinding
import com.sananismayilov.finalproject.databinding.FragmentHomeBinding
import com.sananismayilov.finalproject.util.Util.BASE_URL
import com.sananismayilov.finalproject.util.Util.getImage

class FoodAdapter(val foodlist: List<FoodModel>) :
    RecyclerView.Adapter<FoodAdapter.FoodHolder>() {

    inner class FoodHolder(val binding: FoodrawBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val binding = DataBindingUtil.inflate<FoodrawBinding>(
            LayoutInflater.from(parent.context),
            R.layout.foodraw, parent, false
        )

        return FoodHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodlist.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.binding.food = foodlist[position]
        holder.binding.foodimage.getImage("$BASE_URL//FinalProject/foodimages/${foodlist.get(position).food_image}")
    }


}