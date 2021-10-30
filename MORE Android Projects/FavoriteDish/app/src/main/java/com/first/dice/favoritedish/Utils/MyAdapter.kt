  package com.first.dice.favoritedish.Utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.first.dice.favoritedish.R
import com.first.dice.favoritedish.Update_Dish_Activity


class MyAdapter (
     private val activity : Activity,
     private val listItems : ArrayList<String>,
     private val selection : String,
     ) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view.rootView) {
        // we should Mention the text of lists Dialog

        val texts = view.findViewById<TextView>(R.id.ListText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate the layout of list

        val v = LayoutInflater.from(activity).inflate(R.layout.list_dialog,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // it is the main part in the Recycle View
        // here i am setting item as a value and listItems possion it will get the all the index of that arrayList

        val items = listItems[position]

        // here i am setting the text for the list as the item one By One
        holder.texts.text = items

        holder.texts.setOnClickListener{

            if(activity is Update_Dish_Activity){
                activity.SetClickEventToSelectionDialog(items,selection)
            }
        }

    }

    override fun getItemCount(): Int {
        // it is there to set how many lists we want in recycle View

        return listItems.size
    }

}

