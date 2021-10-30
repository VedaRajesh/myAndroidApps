package com.first.dice.mydatabase

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.first.dice.mydatabase.RoomDB.UserEntity
import com.first.dice.mydatabase.ViewModel.myViewModel
import com.first.dice.mydatabase.databinding.FragmentAddBinding

class add : Fragment() {

    private lateinit var mUserViewModel : myViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentAddBinding.inflate(layoutInflater)

        mUserViewModel = ViewModelProvider(this).get(myViewModel :: class.java)

        view.addButton.setOnClickListener {
            insertDataToDatabase(view)
        }

        return view.root
    }

    private fun insertDataToDatabase(views: FragmentAddBinding) {
        val name = views.name.text.toString()
        val age = views.Age.text
        val lastName = views.lastName.text.toString()

        if (CheckedInput(name, lastName, age)) {
            // code which will execute when EditText is null
            Toast.makeText(this.context, "Please Enter Your Details", Toast.LENGTH_LONG).show()
        } else {
            // code which will execute when EditText is not null
            val userDetails = UserEntity(0,name,lastName,Integer.parseInt(age.toString()))
            mUserViewModel.addUser(userDetails)

            findNavController().navigate(R.id.action_add2_to_list)

            Toast.makeText(this.context,"Added Sussfully",Toast.LENGTH_LONG).show()
        }
    }


    private fun CheckedInput(name: String, Discription: String, age: Editable): Boolean  {
        return TextUtils.isEmpty(name) || TextUtils.isEmpty(Discription) || age.isEmpty()
    }
}

