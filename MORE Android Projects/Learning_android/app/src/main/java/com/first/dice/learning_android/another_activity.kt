package com.first.dice.learning_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class another_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another_activity)

        val textans = findViewById<TextView>(R.id.AnsTextView)

        val ans  = intent.getStringExtra("textAns")
        textans.setText("Welcome :  " + ans)
    }
}