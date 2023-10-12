package com.sananismayilov.finalproject.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.databinding.FragmentSignupBinding
import com.sananismayilov.finalproject.ui.activity.FoodActivity
import com.sananismayilov.finalproject.ui.viewmodel.SignUpViewmodel
import com.sananismayilov.finalproject.util.Util.PrefName
import com.sananismayilov.finalproject.util.Util.getNav
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Signup  : Fragment() {
    private lateinit var binding: FragmentSignupBinding
    private lateinit var viewmodel: SignUpViewmodel
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPreferences = activity?.getSharedPreferences(PrefName, Context.MODE_PRIVATE)!!
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        viewmodel = ViewModelProvider(this).get(SignUpViewmodel::class.java)

        getLoginPage()

        binding.btnsignup.setOnClickListener {
            observeSignUp()
            SignUp()
        }

        return binding.root


    }

    private fun getLoginPage() {
        binding.getLoginpage.setOnClickListener {
            Navigation.getNav(it, R.id.actionloginpage)
        }
    }

    private fun SignUp() {
        val user_name = binding.editname.text.toString()
        val user_surname = binding.editsurname.text.toString()
        val user_email = binding.editemail.text.toString()
        val user_password = binding.editpassword.text.toString()
        val user_phonenumber = binding.editphonenumber.text.toString()
        val user_city = binding.editcity.text.toString()
        val user_adress = binding.editadress.text.toString()

        viewmodel.signup(
            user_name,
            user_surname,
            user_email,
            user_password,
            user_phonenumber,
            user_city,
            user_adress
        )


    }

    private fun observeSignUp() {
        viewmodel.signupstatus.observe(viewLifecycleOwner, Observer {
            if (!it) {
                binding.signupanim.visibility = View.VISIBLE
            } else {
                binding.signupanim.visibility = View.GONE
                val editor = sharedPreferences.edit()
                editor.putBoolean("UserStatus", true).commit()
                editor.putString("User_email", binding.editemail.text.toString()).commit()
                val intent = Intent(activity, FoodActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        })


    }


}