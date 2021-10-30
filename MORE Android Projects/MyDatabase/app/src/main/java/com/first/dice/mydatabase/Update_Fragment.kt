package com.first.dice.mydatabase

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.ListFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.first.dice.mydatabase.RoomDB.UserEntity
import com.first.dice.mydatabase.ViewModel.myViewModel
import com.first.dice.mydatabase.databinding.FragmentUpdateBinding


@Suppress("UNREACHABLE_CODE")
class Update_Fragment : Fragment() {

    private val myArgs by navArgs<Update_FragmentArgs>()
    lateinit var mViewModel : myViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = FragmentUpdateBinding.inflate(layoutInflater)

        v.name.setText(myArgs.currectData.name)
        v.lastname.setText(myArgs.currectData.lastName.toString())
        v.Age.setText(myArgs.currectData.age.toString())

        // Main logic to Update the Data

        v.UpdateButton.setOnClickListener (){
            // Creating a ViewModel
            mViewModel = ViewModelProvider(this).get(myViewModel :: class.java)

            val age = v.Age.text
            val name = v.name.text.toString()
            val lastName = v.lastname.text.toString()

            val updatedUser = UserEntity(myArgs.currectData.id,name,lastName,Integer.parseInt(age.toString()))

            mViewModel.updateUser(updatedUser)
            Toast.makeText(this.context,"Updated sucessfully",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_update_Fragment_to_list)
        }
        setHasOptionsMenu(true)

        return v.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.delect_menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delect -> deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    fun deleteUser(){

        val alertDialog = AlertDialog.Builder(this.context)
        alertDialog.setPositiveButton("Yes"){_,_ ->
            mViewModel = ViewModelProvider(this).get(myViewModel ::class.java)

            mViewModel.delectUser(myArgs.currectData)
            Toast.makeText(this.context,"sucessfully Deleted ${myArgs.currectData.name}",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_update_Fragment_to_list)

        }
        alertDialog.setNegativeButton("No"){_,_ ->

        }
        alertDialog.setMessage("Do you want to Delete '${myArgs.currectData.name}'")
        alertDialog.create().show()
    }

}