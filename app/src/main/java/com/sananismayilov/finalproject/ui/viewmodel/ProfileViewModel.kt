package com.sananismayilov.finalproject.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.data.UserResponse
import com.sananismayilov.finalproject.retrofit.RetrofitUtils
import com.sananismayilov.finalproject.roomdatabase.ProductDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    val Userlist = MutableLiveData<UserResponse>()
    val userdeletestatus = MutableLiveData<Boolean>(false)

    fun getUser(user_email : String){
        CoroutineScope(Dispatchers.Main).launch {
            val response = RetrofitUtils.getInstance().getUser(user_email)
            if (response.isSuccessful){
                if (response.body()?.success == 1){
                    Userlist.value = response.body()
                }
            }
        }
    }

    fun deletecart(context: Context){
        CoroutineScope(Dispatchers.IO).launch{
          ProductDatabase(context).getDao().deleteCart()
        }
    }

    fun deleteUser(user_email: String){
        CoroutineScope(Dispatchers.Main).launch {
            val response = RetrofitUtils.getInstance().deleteUser(user_email)
            if (response.isSuccessful){
                if (response.body()?.success == 1){
                    userdeletestatus.value = true
                }
            }
        }
    }


}