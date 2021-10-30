package com.example.favdish

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.favdish.Utils.Constants
import com.example.favdish.Utils.MyAdapter
import com.example.favdish.databinding.ActivityAddUpdateBinding
import com.example.favdish.databinding.CustomDialogBinding
import com.example.favdish.databinding.DishSelectionDialogBinding
import com.google.android.material.textfield.TextInputLayout
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*


class AddUpdateActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityAddUpdateBinding
    private lateinit var mDialog : Dialog

    //Dialog
    private lateinit var myDishSelectionDialog : Dialog

    // Edit Text (text inputLayout)

    private var mImagePath : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddUpdateBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar!!.apply {
            title = "Add Dish"
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
      mBinding.addImage.setOnClickListener{
          mDialog = Dialog(this)
          val dialogView = CustomDialogBinding.inflate(layoutInflater)
          mDialog.setContentView(dialogView.root)
          mDialog.show()

          openGallary(dialogView)
          openCamera(dialogView)
      }

        // implementing Dialog Recycle View
        val dishType = mBinding.DishTypeET

        val dishCookingTime = mBinding.DishCookingTime
        val dishCategory = mBinding.CategoryET

        val dishMakingSteps = mBinding.MakingStepsET
        val dishIngrediance = mBinding.ingredienceET

    }

    fun openCamera(viewDialog : CustomDialogBinding){
        viewDialog.cameraImageView.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                Dexter.withContext(this).withPermission(
                    android.Manifest.permission.CAMERA
                ).withListener(object : PermissionListener{

                    override fun onPermissionGranted(grantedResponse: PermissionGrantedResponse?) {
                        val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        startActivityForResult(intentCamera, REQUEST_CODE_CAMERA)
                        mDialog.dismiss()
                    }

                    override fun onPermissionDenied(permissionDenied: PermissionDeniedResponse?) {
                        Toast.makeText(this@AddUpdateActivity,"Permission Denied",Toast.LENGTH_LONG).show()
                        alertDialog("CAMERA")
                        mDialog.dismiss()
                    }


                    override fun onPermissionRationaleShouldBeShown(
                        p0: PermissionRequest?,
                        p1: PermissionToken?
                    ) {
                        p1!!.cancelPermissionRequest()
                    }
                }).check()

            }else{
                // this block is for oldest android version
                val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intentCamera, REQUEST_CODE_CAMERA)
            }
        }
    }
    fun alertDialog(name : String){
        AlertDialog.Builder(this)
            .setTitle("if you have Denied but if you want to use ${name} go to settings and enable")
            .setPositiveButton("Go to Setting"){ib , fe ->
                try {
                    val intentSetting = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package",packageName,null)
                    intentSetting.data = uri
                    startActivity(intentSetting)
                }catch(e : ActivityNotFoundException) {
                    Log.i("tag", "not found")
                }
            }
            .setNegativeButton("Don't want"){ jd , r4 ->

            }
            .show()
    }

    fun openGallary(viewDialog: CustomDialogBinding){
        viewDialog.Gallary.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                // this block is for newest version of android
                Dexter.withContext(this).withPermission(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ).withListener(object : PermissionListener{

                    override fun onPermissionGranted(grantedResponse: PermissionGrantedResponse?) {
                        val intentGallary = Intent(Intent.ACTION_PICK)
                        intentGallary.type = "image/*"
                        startActivityForResult(intentGallary, REQUEST_CODE_GALLARY)
                        mDialog.dismiss()
                    }

                    override fun onPermissionDenied(permissionDenied: PermissionDeniedResponse?) {

                        alertDialog("CAMERA")
                        mDialog.dismiss()
                    }


                    override fun onPermissionRationaleShouldBeShown(
                        p0: PermissionRequest?,
                        p1: PermissionToken?
                    ) {
                        p1!!.cancelPermissionRequest()
                    }
                }).check()

            }else{
                // this block is for older version of android
                val intentGallary = Intent(Intent.ACTION_PICK)
                intentGallary.type = "image/*"
                startActivityForResult(intentGallary, REQUEST_CODE_GALLARY)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val addingImage = mBinding.addingImage
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == REQUEST_CODE_CAMERA){
                data?.extras?.let {
                    val thumbmain : Bitmap = data.extras!!.get("data") as Bitmap
                    Glide.with(this)
                        .load(thumbmain)
                        .into(addingImage)

                    mImagePath = saveImageToInternalStorage(thumbmain)
                    Log.i("imagePath",mImagePath)
                }
            }
            if(requestCode == REQUEST_CODE_GALLARY){
                data?.extras?.let {
                    val photoImageUri = data.data
                    Glide.with(this)
                        .load(photoImageUri)
                        .into(addingImage)
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun saveImageToInternalStorage(bitmap: Bitmap): String{
        val wrapper = ContextWrapper(applicationContext)
        var file = wrapper.getDir(Image_Directory,Context.MODE_PRIVATE)
        file = File(file,"${UUID.randomUUID()}.jpeg")

        try {
            val stream : OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream)
            stream.flush()
            stream.close()
        }catch (e :IOException){
            e.printStackTrace()
        }
        return file.absolutePath
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val REQUEST_CODE_GALLARY = 5
        const val REQUEST_CODE_CAMERA = 33

        const val Image_Directory = "Fav Dish Images"
    }
}