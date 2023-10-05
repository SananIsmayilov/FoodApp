package com.sananismayilov.finalproject.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sananismayilov.finalproject.data.CartModel

@Database(entities = [CartModel::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getDao(): ProductDao


    companion object {
        @Volatile
        var instance: ProductDatabase? = null

        val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        fun makeDatabase(context: Context) =
            Room.databaseBuilder(context, ProductDatabase::class.java, "Product")
                .build()
    }
}