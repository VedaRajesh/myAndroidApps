package com.example.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseauth.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.provider.FirebaseInitProvider

class MainActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        // write your code here
//        val option = FirebaseOptions.Builder().setApplicationId("APP_ID")
//            .setGcmSenderId("SENDER_ID").build()
//
//        FirebaseApp.initializeApp(this,option,"[DEFAULT]")
        auth = FirebaseAuth.getInstance()

        // email and passward
        val email = mBinding.gmailET.text.toString()
        val passward = mBinding.passwardET.text.toString()

        auth.createUserWithEmailAndPassword(email,passward).addOnCompleteListener { task ->

            if(task.isSuccessful){
                Toast.makeText(this,"It is successful",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"it is unSuccessful",Toast.LENGTH_LONG).show()
            }
        }
    }

}