package com.first.dice.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.first.dice.bottomnavigation.databinding.FragmentDashboardBinding

class Dashboard_Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentDashboardBinding.inflate(layoutInflater)



        return view.root
    }
}