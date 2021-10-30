package com.first.dice.permissiondialogpassingdata

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.karumi.dexter.Dexter
import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Notification
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.graphics.Bitmap
import android.media.Image
import android.media.audiofx.PresetReverb
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.provider.Settings
import android.widget.*
import androidx.core.app.NotificationCompat
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import java.lang.NullPointerException
import java.security.Permissions
import android.content.Intent as Intent
import com.karumi.dexter.listener.single.PermissionListener as PermissionListener1


class MainActivity : AppCompatActivity() {

    private val requestCodename : Int = 342
    private lateinit var setUpImageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bthOpenGallary = findViewById<Button>(R.id.GallaryPermission)
        bthOpenGallary.setOnClickListener(){
            val intentOpenGallary = Intent(Intent.ACTION_PICK)
            intentOpenGallary.type = "image/*"
            startActivityForResult(intentOpenGallary,requestCodename)
        }

        val btnOpenDialog = findViewById<Button>(R.id.OpenDialog)
        btnOpenDialog.setOnClickListener() {
            // opening a dialog
            // TODO it is for the dialog which is in the Project

            val popupDialog = layoutInflater.inflate(R.layout.dialog_popup,null)

            val dialog: Dialog = Dialog(this)
            dialog.setContentView(popupDialog)
            dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()


            // setting a layoutInflator and setting contant view as dialog_popup.xml

            val editText: EditText = popupDialog.findViewById(R.id.NameEditText)
            val btnSubmit : Button = popupDialog.findViewById(R.id.ButtonSubmit)
            // creating to Edittext to string

            val texting = editText.text

            btnSubmit.setOnClickListener(){
                Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
              dialog.dismiss()
              btnOpenDialog.text = texting
            }
        }

        val cameraPermissionBtn = findViewById<Button>(R.id.CamraPermission)
        cameraPermissionBtn.setOnClickListener {

            AskPermissionForCamera()
          }
        setUpImageView = findViewById<ImageView>(R.id.ImageViewToPutImage)


    }

    // TODO it is the function to ask permission of android version Marsmellow and above

    private fun AskPermissionForCamera(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val DexterPermission  = Dexter.withContext(this).withPermission(
                Manifest.permission.CAMERA

            ).withListener(object  : PermissionListener1 {
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    Toast.makeText(applicationContext,"hello my name is rohan",Toast.LENGTH_SHORT).show()
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    Toast.makeText(applicationContext,"i am going to throw an error",Toast.LENGTH_LONG).show()
                    AlertDialogForIntentSetting()
                }

                override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?,token: PermissionToken?) {

                }
            }).check()
        }else {
            val intentingCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            intentingCamera.setType("image/*")
            startActivityForResult(intentingCamera,requestCodename)
        }
    }

    // TODO it is activity result it is used to pass data to an image without this we can use the camera only not -
    // TODO "the data"

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ( requestCode== requestCodename && resultCode == Activity.RESULT_OK && data !=null) {
            setUpImageView.setImageURI(data.data)
        }
    }

    // TODO it is an Alert Dialog it is used when the Pemission is denyed

    private fun AlertDialogForIntentSetting(){
        val Alerting = AlertDialog.Builder(this@MainActivity)
        Alerting.setMessage("if you want to take photos of your Dish,You should allow the permission if you are not able to" +
                "allow this permission click 'Go To Setting'")
        Alerting.setPositiveButton("Go To Setting"){ dialog, which ->
            try {
                val intentingGoToSetting = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("pacakage",packageName,null)
                intentingGoToSetting.data = uri
            }catch (e:ActivityNotFoundException){
                Toast.makeText(this@MainActivity , "unable to open setting",Toast.LENGTH_LONG).show()
            }
        }

        Alerting.create()

    }
}


