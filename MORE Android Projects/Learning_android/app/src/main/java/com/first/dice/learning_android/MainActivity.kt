package com.first.dice.learning_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SubmitButton = findViewById<Button>(R.id.submitButton)
        val welcomeEntry = findViewById<EditText>(R.id.welcomeEntryET)



        SubmitButton.setOnClickListener(){
            val texting = welcomeEntry.text.toString()
            val intenting = Intent(this,another_activity :: class.java).apply {
                putExtra("textAns",texting)
            }
                  startActivity(intenting)
        }
    }
}