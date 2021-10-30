package com.example.favdish

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.favdish.databinding.FragmentHomeBinding


class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentHomeBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return view.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_add_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addIng -> {
                val intenting = Intent(this.context,AddUpdateActivity::class.java)
                startActivity(intenting)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}