package com.first.dice.myrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.first.dice.myrecycleview.Utility.MyAdapter
import com.first.dice.myrecycleview.Utility.list


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // the main code starts here

        val adapter = MyAdapter(this,list.ColorsName(),list.Discription())
        val recyclerView = findViewById<RecyclerView>(R.id.Rvlist)
        recyclerView.layoutManager = LinearLayoutManager(this)
        DividerItemDecoration(this, DividerItemDecoration. VERTICAL)
        recyclerView.adapter = adapter
    }
}