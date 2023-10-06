package com.sananismayilov.finalproject.ui.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sananismayilov.finalproject.data.CartModel
import com.sananismayilov.finalproject.roomdatabase.ProductDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Collections

class CartViewModel( ) : ViewModel() {
    val cartlist = MutableLiveData<List<CartModel>>()
    val allSale = MutableLiveData<Double>(0.0)

    fun getData(context: Context){
        CoroutineScope(Dispatchers.Main).launch {
           val response =  ProductDatabase(context).getDao().getProduct()
            Collections.reverse(response)
            cartlist.value = response
        }
    }

    fun productDelete(context: Context,cartmodel : CartModel){
        CoroutineScope(Dispatchers.Main).launch {
            ProductDatabase(context).getDao().deleteProduct(cartmodel)
        }
    }

    fun getAllProductSale(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
           val listsale =  ProductDatabase(context).getDao().getAllSales()
            val listcount = ProductDatabase(context).getDao().getAllCount()

            var allsale = 0.0
            for(i in 0 until listcount.size){
                val saleint = listsale[i].toDouble()
                val tempcount = listcount[i]
                val temp = saleint * tempcount
                allsale = allsale+temp

            }
            CoroutineScope(Dispatchers.Main).launch {
                allSale.value = allsale
            }



        }
    }
}