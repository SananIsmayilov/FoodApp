package com.sananismayilov.finalproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.data.FoodModel
import com.sananismayilov.finalproject.databinding.FooddetailrawBinding
import com.sananismayilov.finalproject.databinding.FoodrawBinding
import com.sananismayilov.finalproject.ui.fragments.DetailFoodFragmentDirections
import com.sananismayilov.finalproject.ui.fragments.HomeFragmentDirections
import com.sananismayilov.finalproject.util.Util.BASE_URL
import com.sananismayilov.finalproject.util.Util.getImage

class DetailFoodAdapter(val list: List<FoodModel>) :
    RecyclerView.Adapter<DetailFoodAdapter.FoodHolder>() {

    inner class FoodHolder(val binding: FooddetailrawBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val view = DataBindingUtil.inflate<FooddetailrawBinding>(
            LayoutInflater.from(parent.context),
            R.layout.fooddetailraw, parent, false
        )
        return FoodHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.binding.foodModel = list[position]
        holder.binding.foodimagedetail.getImage(
            "$BASE_URL//FinalProject/foodimages/${
                list.get(
                    position
                ).food_image
            }"
        )
        holder.binding.btnaddfooddetail.setOnClickListener {
            val action =
                DetailFoodFragmentDirections.actionDetailFoodFragmentToFoodBottomSheetFragment2(list[position])
            Navigation.findNavController(it).navigate(action)
        }
    }
}