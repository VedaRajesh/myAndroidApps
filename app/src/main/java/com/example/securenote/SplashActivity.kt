package com.example.securenote

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 3000

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        val imageViewSplash = findViewById<ImageView>(R.id.splashgif)

        hideStatusBar()

        Glide.with(this)
            .load(R.drawable.animation) // Replace with your GIF resource
            .into(imageViewSplash)
        CoroutineScope(Dispatchers.Main).launch {
            delay(splashTimeOut)

            // After delay, navigate to MainActivity
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish() // close this activity
        }// close this activity
    }

    @SuppressLint("ResourceAsColor")
    private fun hideStatusBar() {
        val windows = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = resources.getColor(R.color.white)
        windows.navigationBarColor = resources.getColor(R.color.white)
    }
}