package com.first.dice.withimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn = findViewById<Button>(R.id.shuffelButton)
        btn.setOnClickListener() {
            Toast.makeText(this, "your ans is hi my name is ", Toast.LENGTH_SHORT).show()

        }
    }
}