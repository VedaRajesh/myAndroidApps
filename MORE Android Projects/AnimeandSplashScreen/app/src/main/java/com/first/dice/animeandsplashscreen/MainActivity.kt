package com.first.dice.animeandsplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  
        setContentView(R.layout.activity_main)

        val trial_button = findViewById<Button>(R.id.Trial_button)
        trial_button.setOnClickListener(){
            Toast.makeText(this,"welcome to python",Toast.LENGTH_SHORT).show()
        }
    }
}


