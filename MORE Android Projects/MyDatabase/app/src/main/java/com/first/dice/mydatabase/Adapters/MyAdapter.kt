package com.first.dice.mydatabase.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.first.dice.mydatabase.ListDirections
import com.first.dice.mydatabase.RoomDB.UserEntity
import com.first.dice.mydatabase.Update_FragmentDirections
import com.first.dice.mydatabase.databinding.CustomListViewBinding

class MyAdapter (private val activity : Context): RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    var itemList = arrayListOf<UserEntity>()

    inner class ViewHolder (view : CustomListViewBinding) : RecyclerView.ViewHolder(view.root){
        val firstName = view.FirstName
        val idText = view.SerialNum
        val ageText = view.AgeT
        val rowLayout = view.rowLayout

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = CustomListViewBinding.inflate(LayoutInflater.from(activity),parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.firstName.setText("${currentItem.name}. \n ${currentItem.lastName}")
        holder.idText.text = currentItem.id.toString()
        holder.ageText.text = currentItem.age.toString()
        // setting on click lisner for row layout

        holder.rowLayout.setOnClickListener {
            val action = ListDirections.actionListToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setData(user : List<UserEntity>){
        this.itemList = user as ArrayList<UserEntity>
        notifyDataSetChanged()
    }
}