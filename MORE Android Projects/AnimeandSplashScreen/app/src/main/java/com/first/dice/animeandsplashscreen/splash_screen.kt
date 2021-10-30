package com.first.dice.animeandsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import org.w3c.dom.Text

class splash_screen : AppCompatActivity() {

    private lateinit var roming_text : TextView
    private lateinit var topanimation : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

            // removing a action bar

        supportActionBar?.hide()

        // animating here

        topanimation = AnimationUtils.loadAnimation(this,R.anim.splash_animatiion)
        roming_text = findViewById(R.id.rome)
        roming_text.animation = topanimation

        // delay for splash screen

        Handler().postDelayed({
            // i will write some code to
            val intenting = Intent(this, MainActivity::class.java)
            startActivity(intenting)
            finish()
        },4000)
    }

}
