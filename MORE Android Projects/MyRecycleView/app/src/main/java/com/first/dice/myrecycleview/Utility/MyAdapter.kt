package com.first.dice.myrecycleview.Utility

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.first.dice.myrecycleview.R

class MyAdapter(private val activity: Activity, private val Colordiscription: Unit, private val colorName: Unit): RecyclerView.Adapter<MyAdapter.ViewHolders>(){



   inner class ViewHolders(view : View) : RecyclerView.ViewHolder(view.rootView){

       val Name = view.findViewById<TextView>(R.id.Name)
       val Discription = view.findViewById<TextView>(R.id.Discription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        val v = LayoutInflater.from(activity,).inflate(R.layout.list_rv,parent,false)
        return ViewHolders(v)
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        holder.Discription.text =Colordiscription[position]
        holder.Name.text =colorName[position]
    }

    override fun getItemCount(): Int {
        return colorName.size
    }
}