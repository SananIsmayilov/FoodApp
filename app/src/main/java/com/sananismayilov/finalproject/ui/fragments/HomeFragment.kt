package com.sananismayilov.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.adapter.FoodAdapter
import com.sananismayilov.finalproject.databinding.FragmentHomeBinding
import com.sananismayilov.finalproject.ui.viewmodel.FoodViewModel


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: FoodViewModel
    lateinit var adapter: FoodAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

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
    }

    override fun onResume() {
        viewModel.getFood()
        super.onResume()
    }


}