package com.first.dice.favoritedish

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Splash_Screen : AppCompatActivity() {

    private lateinit var animationForTitle : Animation
    private lateinit var animatedView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__screen)

        // hinding status bar and Action bar

        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // animating here

        animatedView = findViewById(R.id.TV_splash_screen)
        animationForTitle = AnimationUtils.loadAnimation(this,R.anim.anim_top)
        animatedView.animation = animationForTitle

        // using handler to set timer and intent to go to home fragmet.kt
        Handler().postDelayed({
            Toast.makeText(this,"Welcome To Fav Dish",Toast.LENGTH_SHORT).show()
            val intenting = Intent(this,MainActivity :: class.java)
            startActivity(intenting)
            finish()


        },4000)

   }
}