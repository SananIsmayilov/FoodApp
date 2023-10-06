package com.sananismayilov.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sananismayilov.finalproject.R
import com.sananismayilov.finalproject.data.CartModel
import com.sananismayilov.finalproject.databinding.CartrowBinding
import com.sananismayilov.finalproject.ui.viewmodel.CartViewModel
import com.sananismayilov.finalproject.util.Util.getImage
import java.util.Collections

class CartAdapter(
    val context: Context,
    val cartlist: List<CartModel>,
    val viewmodel: CartViewModel
) : RecyclerView.Adapter<CartAdapter.CartHolder>() {
    inner class CartHolder(val binding: CartrowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val view = DataBindingUtil.inflate<CartrowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.cartrow,
            parent,
            false
        )
        return CartHolder(view)
    }

    override fun getItemCount(): Int {
        return cartlist.size
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        val allsale =
            cartlist.get(position).product_count * cartlist[position].product_sale.toDouble()
        holder.binding.cartimage.getImage(cartlist.get(position).product_image)
        holder.binding.cartsale.text = "Qiymət : $${cartlist.get(position).product_sale}"
        holder.binding.cartcount.text = "Say : ${cartlist.get(position).product_count.toString()}"
        holder.binding.cartname.text =
            cartlist.get(position).product_name
        holder.binding.cartallsale.text = "$$allsale "

        holder.binding.cartdelete.setOnClickListener {
            val navcontroller = Navigation.findNavController(it)

            Snackbar.make(it, "Silinsin?", Snackbar.LENGTH_SHORT)
                .setAction("Sil", View.OnClickListener {
                    viewmodel.productDelete(context, cartlist.get(position))
                    navcontroller.navigate(R.id.actionrepeat)

                })
                .show()
        }

    }
}