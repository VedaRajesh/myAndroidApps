package com.first.dice.customactionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.view.SupportActionModeWrapper
import org.w3c.dom.Text

class SplashAnimation : AppCompatActivity() {

    private lateinit var wel : TextView
    private lateinit var me : TextView
    private lateinit var anim_wel : Animation
    private lateinit var anim_me : Animation

    private lateinit var co_down : TextView
    private lateinit var anim_co_down : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_animation)

        // hiding action bar for splash screen and status bar in kotlin android studio

        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // animating

        wel = findViewById(R.id.WEL)
        anim_wel = AnimationUtils.loadAnimation(this,R.anim.anim_for_welme)
        wel.animation = anim_wel

        me = findViewById(R.id.ME)
        anim_wel = AnimationUtils.loadAnimation(this,R.anim.anim_for_welme)
        me.animation = anim_wel

        co_down = findViewById(R.id.CO)
        anim_co_down = AnimationUtils.loadAnimation(this,R.anim.anim_down_co)
        co_down.animation = anim_co_down

        Handler().postDelayed({
            val intenting = Intent(this,MainActivity::class.java)
            startActivity(intenting)
            finish()
        },1110)
    }
}