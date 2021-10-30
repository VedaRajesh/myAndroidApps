package com.example.favdish.Utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.favdish.databinding.CustomListViewBinding

class MyAdapter(
    private val activity: Activity,
    private val itemList: ArrayList<String>,
    private val selection: String

):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view : CustomListViewBinding): RecyclerView.ViewHolder(view.root){
        val text : TextView= view.DishName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = CustomListViewBinding.inflate(LayoutInflater.from(activity),parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemLists = itemList[position]
        holder.text.text = itemLists

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}