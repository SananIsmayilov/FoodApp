package com.sananismayilov.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.adapter.CartAdapter
import com.sananismayilov.finalproject.databinding.CartrowBinding
import com.sananismayilov.finalproject.databinding.FragmentCartBinding
import com.sananismayilov.finalproject.ui.viewmodel.CartViewModel
import kotlinx.coroutines.newFixedThreadPoolContext
import java.util.Collections


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(CartViewModel::class.java)

        observeProduct()
        return binding.root
    }

    private fun observeProduct() {
        viewModel.cartlist.observe(viewLifecycleOwner, Observer {
            binding.cartrecyc.layoutManager = LinearLayoutManager(requireContext())
            adapter = CartAdapter(requireActivity(), it, viewModel)
            binding.cartrecyc.adapter = adapter

        })

        viewModel.allSale.observe(viewLifecycleOwner, Observer {
            binding.allsale.text = "$it$"
        })
    }

    override fun onResume() {
        viewModel.getData(requireActivity())
        viewModel.getAllProductSale(requireActivity())
        super.onResume()
    }


}