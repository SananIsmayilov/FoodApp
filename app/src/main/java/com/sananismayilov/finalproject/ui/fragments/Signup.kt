package com.sananismayilov.finalproject.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.Navigation
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.databinding.FragmentSignupBinding
import com.sananismayilov.finalproject.util.Util.getNav


class Signup : Fragment() {
    private lateinit var binding: FragmentSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)

        getLoginPage()

        return binding.root


        //name +
        //email +
        //surname +
        //password +
        //phonenumber +
        //adress +
        //city +
        //id primary key

    }

    private fun getLoginPage(){
        binding.getLoginpage.setOnClickListener {
            Navigation.getNav(it,R.id.actionloginpage)
        }
    }


}