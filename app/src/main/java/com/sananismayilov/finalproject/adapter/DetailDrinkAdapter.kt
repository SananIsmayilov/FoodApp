package com.sananismayilov.finalproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.data.DrinkModel
import com.sananismayilov.finalproject.databinding.DrinkdetailrowBinding
import com.sananismayilov.finalproject.databinding.FooddetailrawBinding
import com.sananismayilov.finalproject.databinding.FragmentDetailDrinkBinding
import com.sananismayilov.finalproject.ui.fragments.DetailDrinkFragment
import com.sananismayilov.finalproject.ui.fragments.DetailDrinkFragmentDirections
import com.sananismayilov.finalproject.ui.fragments.HomeFragmentDirections
import com.sananismayilov.finalproject.ui.viewmodel.HomeViewModel
import com.sananismayilov.finalproject.util.Util
import com.sananismayilov.finalproject.util.Util.getImage

class DetailDrinkAdapter(val drinklist : List<DrinkModel>) : RecyclerView.Adapter<DetailDrinkAdapter.DrinkHolder>() {
    inner class DrinkHolder(val binding : DrinkdetailrowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkHolder {
        val view = DataBindingUtil.inflate<DrinkdetailrowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.drinkdetailrow, parent, false
        )
        return  DrinkHolder(view)
    }

    override fun getItemCount(): Int {
        return drinklist.size
    }

    override fun onBindViewHolder(holder: DrinkHolder, position: Int) {
        holder.binding.drinkModel = drinklist.get(position)
        holder.binding.drinkimagedetail.getImage("${Util.BASE_URL}//FinalProject/drinkimages/${drinklist.get(position).drink_image}")
        holder.binding.btnadddrinkdetail.setOnClickListener {
            val action = DetailDrinkFragmentDirections.actiondetailtobottom(drinklist[position])
            Navigation.findNavController(it).navigate(action)
        }
    }
}