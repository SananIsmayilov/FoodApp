package com.sananismayilov.finalproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.databinding.ActivityFoodBinding
import com.sananismayilov.finalproject.retrofit.RetrofitUtils
import com.sananismayilov.finalproject.ui.fragments.CartFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class FoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        NavigationUI.setupWithNavController(binding.btmview,navHostFragment.navController)


    }
}


