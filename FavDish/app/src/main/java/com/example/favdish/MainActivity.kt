package com.example.favdish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.favdish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fragmentHdome = Home()
    private val fragmentDashboard = Dashboard()
    private val fragmentNotification = Notification()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val bottomNavigationView = mBinding.bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeButton -> {
                    replaceFragment(fragmentHdome)
                    actionBar?.title = "Home"
                }

                R.id.dashboardButton -> {
                    replaceFragment(fragmentDashboard)
                    actionBar?.title = "Dashboard"
                }

                R.id.notificationButton -> {
                    replaceFragment(fragmentNotification)
                    actionBar?.title = "Notification"
                }
            }
            true
        }

}

    fun replaceFragment(fragment : Fragment){
        val transcation = supportFragmentManager.beginTransaction()
        transcation.replace(R.id.fragmentContainerView,fragment)
        transcation.commit()
    }
}