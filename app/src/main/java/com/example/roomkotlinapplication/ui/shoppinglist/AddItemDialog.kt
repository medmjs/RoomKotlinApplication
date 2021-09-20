package com.example.roomkotlinapplication.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.roomkotlinapplication.R
import com.example.roomkotlinapplication.data.entities.ShoppingItem

class AddItemDialog(context: Context,var addDialogListener: AddDialogListener):AppCompatDialog(context) {
    lateinit var et_name:EditText
    lateinit var et_amount:EditText
    lateinit var tv_ok:TextView
    lateinit var tv_cancel:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_dialog)
        et_name = findViewById(R.id.et_custom_dialog_name)!!
        et_amount= findViewById(R.id.et_custom_dialog_amount)!!

        tv_ok = findViewById<TextView>(R.id.tv_custom_dialog_ok)!!
        tv_cancel = findViewById<TextView>(R.id.tv_custom_dialog_concel)!!

        tv_ok.setOnClickListener {
            var name = et_name.text.toString()
            var amount = et_amount.text.toString().toInt()

            if (name.isEmpty()){
                Toast.makeText(context,"Name is Empity ",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var item = ShoppingItem(name,amount)
            addDialogListener.onAddButtonClick(item)
            dismiss()

        }

        tv_cancel.setOnClickListener {
            cancel()
        }
    }
}