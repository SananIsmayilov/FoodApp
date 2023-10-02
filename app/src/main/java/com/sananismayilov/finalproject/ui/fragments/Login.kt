package com.sananismayilov.finalproject.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.databinding.FragmentLoginBinding
import com.sananismayilov.finalproject.ui.activity.FoodActivity
import com.sananismayilov.finalproject.ui.viewmodel.LoginViewModel
import com.sananismayilov.finalproject.util.Util.PrefName


class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        sharedPreferences =
            requireActivity()?.getSharedPreferences(PrefName, Context.MODE_PRIVATE)!!

        binding.btnlogin1.setOnClickListener {
            observeloginstatus()
            loginuser()
            println("Error1 +")

        }


        return binding.root
    }

    fun loginuser() {
        val email: String = binding.editemaillogin.text.toString()
        val password: String = binding.editpasswordlogin.text.toString()
        viewModel.login(email, password)
    }

    fun observeloginstatus() {
        viewModel.loginstatus.observe(viewLifecycleOwner, Observer {
            if (it) {
                editor = sharedPreferences.edit()
                editor.putBoolean("UserStatus", true).commit()
                editor.putString("User_email",binding.editemaillogin.text.toString()).commit()
                val intent = Intent(activity, FoodActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else{
                binding.loginanim.setAnimation(R.raw.usernotfound)
                binding.loginanim.scaleType = ImageView.ScaleType.FIT_CENTER
                binding.loginanim.visibility = View.VISIBLE
            }
        })
    }


}