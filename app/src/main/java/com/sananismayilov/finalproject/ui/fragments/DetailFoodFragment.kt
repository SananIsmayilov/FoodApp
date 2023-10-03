package com.sananismayilov.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.adapter.DetailFoodAdapter
import com.sananismayilov.finalproject.databinding.FragmentDetailFoodBinding
import com.sananismayilov.finalproject.ui.viewmodel.DetailFoodViewModel


class DetailFoodFragment : Fragment() {
    private lateinit var binding: FragmentDetailFoodBinding
    private lateinit var viewModel: DetailFoodViewModel
    private lateinit var adapter: DetailFoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailFoodBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(DetailFoodViewModel::class.java)

        binding.backbtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionhome)
        }

        observeFood()
        return binding.root
    }

    private fun observeFood() {
        viewModel.foodlist.observe(viewLifecycleOwner, Observer {
            binding.fooddetailrecyc.layoutManager = LinearLayoutManager(context)
            val list = it.foodlist
            adapter = DetailFoodAdapter(list)
            binding.fooddetailrecyc.adapter = adapter
        })
    }


    override fun onResume() {
        viewModel.getFood()
        super.onResume()
    }


}