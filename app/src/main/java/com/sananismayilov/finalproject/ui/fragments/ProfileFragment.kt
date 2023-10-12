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
import androidx.lifecycle.get
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.databinding.FragmentProfileBinding
import com.sananismayilov.finalproject.ui.activity.LoginandRegisterActivity
import com.sananismayilov.finalproject.ui.activity.Loginandregisterprewiew
import com.sananismayilov.finalproject.ui.viewmodel.ProfileViewModel
import com.sananismayilov.finalproject.util.Util
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewmodel: ProfileViewModel
    private lateinit var sp: SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        viewmodel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        sp = requireActivity().getSharedPreferences(Util.PrefName, Context.MODE_PRIVATE)
        val user_email: String? = sp.getString("User_email", "")
        user_email?.let {
            binding.profileemail.setText(it)
            viewmodel.getUser(user_email)
        }

        binding.profilelogout.setOnClickListener {
            viewmodel.deletecart(requireActivity())
            editor = sp.edit()
            editor.putBoolean("UserStatus", false).commit()
            val intent = Intent(requireActivity(),LoginandRegisterActivity::class.java)
            startActivity(intent)
        }
        binding.profileremove.setOnClickListener {
            if (user_email != null) {
                viewmodel.deleteUser(user_email)
            }
        }


        observeUser()
        return binding.root
    }

    private fun observeUser() {
        viewmodel.Userlist.observe(viewLifecycleOwner, Observer {
            binding.profilepassword.setText(it.userlist[0].user_password)
            binding.profilephonenumber.setText(it.userlist[0].user_phonenumber)
        })

        viewmodel.userdeletestatus.observe(viewLifecycleOwner, Observer {
            if (it){
                editor = sp.edit()
                editor.putBoolean("UserStatus", false).commit()
                val intent = Intent(requireActivity(),LoginandRegisterActivity::class.java)
                startActivity(intent)
            }
        })
    }



}