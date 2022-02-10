package com.b12game.ebay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b12game.ebay.adapter.FavouriteAdapter
import com.b12game.ebay.model.Favourite

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)

        val manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.setLayoutManager(manager)

        refreshAdapter(getFavourites())
    }


    private fun refreshAdapter(items: ArrayList<Favourite>) {
        val adapter = FavouriteAdapter(this,items)
        recyclerView!!.adapter = adapter

    }

    private fun getFavourites(): ArrayList<Favourite> {
        val items: ArrayList<Favourite> = ArrayList<Favourite>()
        for(i in 0..20){
            if(i % 2 == 0){
                items.add(Favourite("Apple Watch Grey",R.drawable.apple_watch))
            }else{
                items.add(Favourite("Apple Watch",R.drawable.apple_watch3))
            }

        }

        return items

    }
}