package com.example.roomkotlinapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomkotlinapplication.data.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        var instence : ShoppingDatabase?=null

        var LOCK =Any()
        operator fun invoke(context: Context)= instence ?: synchronized(LOCK) {
            instence ?: createDatabase(context).also { instence =it }
        }

        fun createDatabase(context:Context) = Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java,"shoppingDB").build()


    }


}