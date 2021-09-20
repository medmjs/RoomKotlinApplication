package com.example.roomkotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomkotlinapplication.adapter.ShoppingAdapter
import com.example.roomkotlinapplication.data.db.ShoppingDatabase
import com.example.roomkotlinapplication.data.entities.ShoppingItem
import com.example.roomkotlinapplication.data.repositories.Repository
import com.example.roomkotlinapplication.ui.shoppinglist.AddDialogListener
import com.example.roomkotlinapplication.ui.shoppinglist.AddItemDialog
import com.example.roomkotlinapplication.ui.shoppinglist.ShoppingViewModel
import com.example.roomkotlinapplication.ui.shoppinglist.ShoppingViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ShoppingViewModel
    lateinit var fab_add :FloatingActionButton
    lateinit var rv_item :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_add = findViewById(R.id.fab_add)
        rv_item =findViewById(R.id.main_rv)



        var ShoppingDB = ShoppingDatabase(this)
        var repository = Repository(ShoppingDB)
        var viewModelFactory = ShoppingViewModelFactory(repository)
        viewModel =ViewModelProviders.of(this,viewModelFactory).get(ShoppingViewModel::class.java)

        var adapter = ShoppingAdapter(listOf(),viewModel)
        rv_item.layoutManager = LinearLayoutManager(this)
        rv_item.adapter =adapter

        viewModel.getAllItem().observe(this, Observer {
            adapter.itemList =it
            adapter.notifyDataSetChanged()

        })







        fab_add.setOnClickListener {
            AddItemDialog(
                this,
                object : AddDialogListener{
                    override fun onAddButtonClick(item: ShoppingItem) {
                        viewModel.upSet(item)
                        
                    }
                }
            ).show()

        }





    }
}