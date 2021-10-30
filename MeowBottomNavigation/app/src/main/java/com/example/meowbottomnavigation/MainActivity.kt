package com.example.meowbottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.meowbottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val settingFragment = Setting()
    private val homeFragment = Home()
    private val dashboardFragment = Dashboard()
    private val menuFragment = menu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val bottomNavigation : MeowBottomNavigation = mBinding.meowBottomNavigation

        supportActionBar?.hide()

//        val appBarNotification = AppBarConfiguration(setOf(
//            R.drawable.ic_baseline_home_24,
//            R.drawable.ic_baseline_menu_24,
//            R.drawable.ic_baseline_dashboard_24,
//            R.drawable.ic_baseline_settings_24,
//        ))

        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_baseline_home_24))
        bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_baseline_menu_24))
        bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_baseline_dashboard_24))
        bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.ic_baseline_settings_24))

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> replaceFragment(homeFragment)

                1 -> replaceFragment(menuFragment)

                2 -> replaceFragment(dashboardFragment)

                3 -> replaceFragment(settingFragment)
            }
        }
//        val navController = findNavController(R.id.fragmentContainerView)
//        setupActionBarWithNavController(navController,appBarNotification)
    }
    fun replaceFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView,fragment)
        transaction.commit()
    }
}