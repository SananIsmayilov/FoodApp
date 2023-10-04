package com.sananismayilov.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.adapter.DrinkAdapter
import com.sananismayilov.finalproject.adapter.FoodAdapter
import com.sananismayilov.finalproject.databinding.FragmentHomeBinding
import com.sananismayilov.finalproject.ui.viewmodel.HomeViewModel


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel
    lateinit var adapter: FoodAdapter
    lateinit var drinkAdapter: DrinkAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.foodcategory.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actiondetail)
        }

        binding.drinkcategory.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actiondrinkdetail)
        }


        observeFood()
        return binding.root
    }

    fun observeFood() {
        viewModel.foodlist.observe(viewLifecycleOwner, Observer {
            binding.foodrecylerview.layoutManager =
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
            val list = it.foodlist
            adapter = FoodAdapter(list)
            binding.loadinglottie.visibility = View.GONE
            binding.foodrecylerview.adapter = adapter
        })

        viewModel.drinklist.observe(viewLifecycleOwner, Observer {
            binding.drinkrecylerview.layoutManager =
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
            val list = it.drinks
            drinkAdapter = DrinkAdapter(list)
            binding.loadinglottiedrink.visibility = View.GONE
            binding.drinkrecylerview.adapter = drinkAdapter

        })
    }

    override fun onResume() {
        viewModel.getFood()
        viewModel.getDrink()
        super.onResume()
    }


}