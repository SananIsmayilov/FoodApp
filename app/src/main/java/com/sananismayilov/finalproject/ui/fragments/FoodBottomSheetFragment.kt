package com.sananismayilov.finalproject.ui.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.data.CartModel
import com.sananismayilov.finalproject.data.FoodModel
import com.sananismayilov.finalproject.databinding.FragmentBottomSheetBinding
import com.sananismayilov.finalproject.databinding.FragmentDetailFoodBinding
import com.sananismayilov.finalproject.roomdatabase.ProductDatabase
import com.sananismayilov.finalproject.util.Util
import com.sananismayilov.finalproject.util.Util.getImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding
    private lateinit var foodModel: FoodModel
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet, container, false)
        arguments?.let {
            val Food = FoodBottomSheetFragmentArgs.fromBundle(it).food
            binding.foodModel = Food
            binding.foodimagebottom.getImage("${Util.BASE_URL}//FinalProject/foodimages/${Food.food_image}")
            foodModel = Food
        }
        countFood()
        binding.addcartbottomsheet.setOnClickListener {
            val cartModel =
                CartModel(
                    0,
                    foodModel.food_name,
                    "${Util.BASE_URL}//FinalProject/foodimages/${foodModel.food_image}",
                    foodModel.food_sale,
                    count
                )
            CoroutineScope(Dispatchers.IO).launch {
                ProductDatabase(requireActivity()).getDao().insertProduct(cartModel)
            }
            Snackbar.make(it, "Səbətə əlavə edildi", Snackbar.LENGTH_SHORT)
                .show()

        }




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