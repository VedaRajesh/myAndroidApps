package com.first.dice.favoritedish.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.first.dice.favoritedish.R
import com.first.dice.favoritedish.Update_Dish_Activity
import com.first.dice.favoritedish.ui.viewModels.HomeViewModel

class Home : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

   // customize menu part 1 start here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    // customize menu part 1 ends here

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    // customize menu part 2 start here

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_actionbar, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

       if (item.itemId == R.id.add_Plus){
           val intentinghe = Intent(this.context,Update_Dish_Activity :: class.java)
           startActivity(intentinghe)
       }

        return true
    }


    // customize menu part 2 ends here
}