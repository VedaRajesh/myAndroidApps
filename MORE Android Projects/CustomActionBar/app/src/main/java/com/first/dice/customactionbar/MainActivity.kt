package com.first.dice.customactionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var ButtonYes: Button
    private lateinit var ButtonNo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        ButtonYes = findViewById(R.id.btnYes)
        ButtonNo = findViewById(R.id.btnNo)

        ButtonNo.setOnClickListener() {
            Toast.makeText(this, "you said no here :(", Toast.LENGTH_SHORT).show()
        }

        ButtonYes.setOnClickListener() {
            Toast.makeText(this, "you said Yes :)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflateing = menuInflater
        inflateing.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val ids = item.itemId

        when (ids) {
            R.id.like -> Toast.makeText(this, "Thanks to like", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}