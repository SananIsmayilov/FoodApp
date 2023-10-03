package com.sananismayilov.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.data.FoodResponse
import com.sananismayilov.finalproject.retrofit.RetrofitUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFoodViewModel : ViewModel() {
    val foodlist = MutableLiveData<FoodResponse>()

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

}