package com.sananismayilov.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.adapter.DetailDrinkAdapter
import com.sananismayilov.finalproject.adapter.DetailFoodAdapter
import com.sananismayilov.finalproject.databinding.FragmentDetailDrinkBinding
import com.sananismayilov.finalproject.databinding.FragmentDetailFoodBinding
import com.sananismayilov.finalproject.ui.viewmodel.DetailDrinkViewModel
import com.sananismayilov.finalproject.ui.viewmodel.DetailFoodViewModel


class DetailDrinkFragment : Fragment() {
    private lateinit var binding: FragmentDetailDrinkBinding
    private lateinit var viewModel: DetailDrinkViewModel
    private lateinit var adapter: DetailDrinkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailDrinkBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(DetailDrinkViewModel::class.java)

        binding.backbtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionhometodrinkdetail)
        }


        observeDrink()

        return binding.root
    }

    private fun observeDrink() {
        viewModel.drinklist.observe(viewLifecycleOwner, Observer {
            binding.drinkdetailrecyc.layoutManager = LinearLayoutManager(context)
            val list = it.drinks
            adapter = DetailDrinkAdapter(list)
            binding.drinkdetailrecyc.adapter = adapter
        })
    }

    override fun onResume() {
        viewModel.getDrink()
        super.onResume()
    }


}