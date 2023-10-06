package com.sananismayilov.finalproject.ui.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.data.CartModel
import com.sananismayilov.finalproject.data.DrinkModel
import com.sananismayilov.finalproject.databinding.FragmentBottomSheetBinding
import com.sananismayilov.finalproject.databinding.FragmentDetailFoodBinding
import com.sananismayilov.finalproject.databinding.FragmentDrinkBottomSheetBinding
import com.sananismayilov.finalproject.roomdatabase.ProductDatabase
import com.sananismayilov.finalproject.util.Util
import com.sananismayilov.finalproject.util.Util.getImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrinkBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDrinkBottomSheetBinding
    private lateinit var drinkmodel: DrinkModel
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_drink_bottom_sheet,
                container,
                false
            )
        arguments?.let {
            val Drink = DrinkBottomSheetArgs.fromBundle(it).Drink
            binding.drinkModel = Drink
            drinkmodel = Drink
            binding.drinkimagebottom.getImage("${Util.BASE_URL}//FinalProject/drinkimages/${Drink.drink_image}")
        }

        binding.addcartbottomsheet.setOnClickListener {
            val cartModel = CartModel(
                0,
                drinkmodel.drink_name,
                "${Util.BASE_URL}//FinalProject/drinkimages/${drinkmodel.drink_image}",
                drinkmodel.drink_sale,
                count
            )
            CoroutineScope(Dispatchers.IO).launch {
                ProductDatabase(requireActivity()).getDao().insertProduct(cartModel)
            }
            Snackbar.make(it, "Səbətə əlavə edildi", Snackbar.LENGTH_SHORT)
                .show()


        }



        countFood()
        return binding.root
    }


    private fun countFood() {
        binding.countplus.setOnClickListener {
            count++;
            binding.counttext.text = "$count"
        }


        binding.countminus.setOnClickListener {
            if (count > 1) {
                count--
            }
            binding.counttext.text = "$count"
        }


    }

}