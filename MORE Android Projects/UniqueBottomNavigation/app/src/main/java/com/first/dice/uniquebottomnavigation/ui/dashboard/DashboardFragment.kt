package com.first.dice.uniquebottomnavigation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.first.dice.uniquebottomnavigation.R
import com.first.dice.uniquebottomnavigation.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = FragmentDashboardBinding.inflate(layoutInflater)

        return view.root
    }
}