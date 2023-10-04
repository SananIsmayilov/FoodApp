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
import com.sananismayilov.finalproject.databinding.FragmentBottomSheetBinding
import com.sananismayilov.finalproject.databinding.FragmentDetailFoodBinding
import com.sananismayilov.finalproject.util.Util
import com.sananismayilov.finalproject.util.Util.getImage

class FoodBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding
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
        }

        binding.addcartbottomsheet.setOnClickListener {
            Snackbar.make(it,"Səbətə əlavə edildi",Snackbar.LENGTH_SHORT)
                .setTextColor(Color.parseColor("#ff4f4f"))
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