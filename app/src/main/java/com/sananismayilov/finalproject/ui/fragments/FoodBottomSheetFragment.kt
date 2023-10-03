package com.sananismayilov.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.databinding.FragmentBottomSheetBinding
import com.sananismayilov.finalproject.databinding.FragmentDetailFoodBinding
import com.sananismayilov.finalproject.util.Util
import com.sananismayilov.finalproject.util.Util.getImage

class FoodBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_bottom_sheet,container,false)
        arguments?.let {
            val Food = FoodBottomSheetFragmentArgs.fromBundle(it).food
            binding.foodModel = Food
            binding.foodimagebottom.getImage("${Util.BASE_URL}//FinalProject/foodimages/${Food.food_image}")
        }


        return binding.root
    }


}