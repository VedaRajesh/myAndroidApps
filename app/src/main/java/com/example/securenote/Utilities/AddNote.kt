package com.example.securenote.Utilities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.securenote.Models.Note
import com.example.securenote.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.logging.SimpleFormatter


class AddNote : AppCompatActivity() {

    private lateinit var note1:Note
    private lateinit var old_note:Note
    var isUpdate=false
val title=findViewById<TextView>(R.id.tv_Title)
    val note=findViewById<TextView>(R.id.tv_Note)
    val check=findViewById<ImageView>(R.id.check)
    val back=findViewById<ImageView>(R.id.back)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.item_note)

        try{
            old_note=intent.getSerializableExtra("current_note") as Note
            title.setText(old_note.title)
            note.setText(old_note.note)
            isUpdate=true


        }catch (e:Exception){
            e.printStackTrace()
        }
        check.setOnClickListener{
            val t=title.text.toString()
            val n=note.text.toString()

            if(t.isNotEmpty()||n.isNotEmpty())
            {
                val formatter=SimpleDateFormat("EEE, d MMM YYYY HH:mm a")
                if(isUpdate){
                    note1=Note(
                        old_note.id,t,n,formatter.format((Date())
                        )
                    )

                }else
                {
                    note1=Note(
                        null,t,n,formatter.format(Date())
                    )
                }
                val intent=Intent()
                intent.putExtra("note",note1)
                setResult(Activity.RESULT_OK,intent)
            }else
            {
                Toast.makeText(this@AddNote,"Please add some data",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        back.setOnClickListener {

        }
    }
}