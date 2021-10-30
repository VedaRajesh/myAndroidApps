package com.first.dice.mydatabase

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.first.dice.mydatabase.Adapters.MyAdapter
import com.first.dice.mydatabase.ViewModel.myViewModel
import com.first.dice.mydatabase.databinding.FragmentListBinding


class List : Fragment(R.layout.fragment_list) {


    lateinit var mUserViewModel : myViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentListBinding.inflate(layoutInflater)

        // adding the data to recycle View
        val recycleView = view.RV
        recycleView.layoutManager = LinearLayoutManager(this.context)
        val mAdapter = MyAdapter(requireContext())
        recycleView.adapter = mAdapter

        // mainLogic to add the Data
        mUserViewModel = ViewModelProvider(this).get(myViewModel ::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            mAdapter.setData(user)
        })

        view.floBTN.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_add2)
        }

        setHasOptionsMenu(true)
        return view.root

    }

    fun deleteUser(){

        val alertDialog = AlertDialog.Builder(this.context)
        alertDialog.setPositiveButton("Yes"){_,_ ->
            mUserViewModel = ViewModelProvider(this).get(myViewModel ::class.java)

            mUserViewModel.delectAllUser()
            Toast.makeText(this.context,"sucessfully Deleted All", Toast.LENGTH_LONG).show()

        }
        alertDialog.setNegativeButton("No"){_,_ ->

        }
        alertDialog.setMessage("Sure want to delete all")
        alertDialog.create().show()
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
    }}