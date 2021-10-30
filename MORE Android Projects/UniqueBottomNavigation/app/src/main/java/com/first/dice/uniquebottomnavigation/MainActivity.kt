package com.first.dice.uniquebottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.first.dice.uniquebottomnavigation.ui.dashboard.DashboardFragment
import com.first.dice.uniquebottomnavigation.ui.home.HomeFragment
import com.first.dice.uniquebottomnavigation.ui.notifications.NotificationsFragment
import com.google.android.material.bottomappbar.BottomAppBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)

        val fragmentHome = HomeFragment()
        val fragmentDashboard = DashboardFragment()
        val fragmentNotification = NotificationsFragment()
        val menuFragment = menu_fragment()

        bottomAppBar.setOnMenuItemClickListener(){menuItem ->

            when(menuItem.itemId){
                R.id.navigation_home ->{
                    replaceFragment(fragmentHome)
                }
                R.id.navigation_dashboard ->{
                    replaceFragment(fragmentDashboard)
                }
                R.id.navigation_notifications ->{
                    replaceFragment(fragmentNotification)
                }
            }
         true
        }
        bottomAppBar.setNavigationOnClickListener {
            replaceFragment(menuFragment)
        }

    }

    private fun replaceFragment(fragment : Fragment){
        if (fragment != null) {
            val transction = supportFragmentManager.beginTransaction()
            transction.replace(R.id.fragment,fragment)
            transction.commit()
        }
    }

     
}