package com.sananismayilov.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.data.DrinkResponse
import com.sananismayilov.finalproject.data.FoodResponse
import com.sananismayilov.finalproject.retrofit.RetrofitUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val foodlist = MutableLiveData<FoodResponse>()
    val drinklist = MutableLiveData<DrinkResponse>()

    fun getFood() {
        CoroutineScope(Dispatchers.Main).launch {
            val response = RetrofitUtils.getInstance().getFood()

            if (response.isSuccessful) {
                if (response.body()?.success == 1) {
                    foodlist.value = response.body()
                }
            }
        }
    }


    fun getDrink() {
        CoroutineScope(Dispatchers.Main).launch {
            val response = RetrofitUtils.getInstance().getDrink()
            if (response.isSuccessful) {
                if (response.body()?.success == 1) {
                    drinklist.value = response.body()
                }
            }

        }
    }
}