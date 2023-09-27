package com.sananismayilov.finalproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.databinding.FragmentLoginandregisterprewiewBinding
import com.sananismayilov.finalproject.util.Util.getNav

class Loginandregisterprewiew : Fragment() {
    private lateinit var binding: FragmentLoginandregisterprewiewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginandregisterprewiewBinding.inflate(inflater, container, false)
        actionpage()




        return binding.root
    }

    fun actionpage(){
        binding.btnlogin.setOnClickListener {
            Navigation.getNav(it,R.id.actionlogin)
        }

        binding.btnsignup.setOnClickListener {
            Navigation.getNav(it,R.id.actionsignup)
        }
    }

}