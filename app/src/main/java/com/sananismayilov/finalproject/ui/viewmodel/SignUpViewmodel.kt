package com.sananismayilov.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.retrofit.RetrofitApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewmodel @Inject constructor(val retrofitApi: RetrofitApi): ViewModel() {

    val signupstatus = MutableLiveData<Boolean>(false)

    fun signup(
        user_name: String,
        user_surname: String,
        user_email: String,
        user_password: String,
        user_phonenumber: String,
        user_city: String,
        user_adress: String,
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = retrofitApi.insertUserssignUp(
                    user_name,
                    user_surname,
                    user_email,
                    user_password,
                    user_phonenumber,
                    user_city,
                    user_adress
                )
                if (response.isSuccessful) {
                    if (response.body()?.success == 1) {
                        signupstatus.value = true
                        println("ResponsE   ${response.body()?.message.toString()}")
                    } else {
                        signupstatus.value = false
                    }
                }
            } catch (e: Exception) {
                println("Error1 ${e.localizedMessage}")
            }

        }

    }
}