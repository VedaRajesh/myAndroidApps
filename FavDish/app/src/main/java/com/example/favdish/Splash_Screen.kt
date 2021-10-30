package com.example.favdish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.favdish.databinding.ActivitySplashScreenBinding

class Splash_Screen : AppCompatActivity() {

    private lateinit var mBinding : ActivitySplashScreenBinding
    private lateinit var animation : Animation
    private lateinit var titleTV : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        titleTV = mBinding.TV
        animation = AnimationUtils.loadAnimation(this,R.anim.fav_dish_logo_animation)
        titleTV.animation = animation

        Handler().postDelayed({
            val intenting = Intent(this,MainActivity :: class.java)
            startActivity(intenting)
            finish()
        },1624)
    }
}