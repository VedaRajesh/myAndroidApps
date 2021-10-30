package com.first.dice.favoritedish

import android.app.AlertDialog
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.inputmethodservice.KeyboardView
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.first.dice.favoritedish.Utils.Constants
import com.first.dice.favoritedish.Utils.MyAdapter
import com.google.android.material.snackbar.Snackbar
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
import kotlin.collections.ArrayList


class Update_Dish_Activity : AppCompatActivity() {

    private var iv_ImagePath = ""

    private lateinit var customDialog : Dialog
    private lateinit var etType: EditText
    private lateinit var etTime : EditText
    private lateinit var btnSubmit : Button
    private lateinit var EDName : EditText
    private lateinit var imageAddingImage : ImageView
    private lateinit var EDIngrediance : EditText
    private lateinit var EDMakingSteps : EditText
    private lateinit var EDWhereThisDishISPopular : EditText

    private lateinit var etCatogary : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update__dish_)
        /// open a dialog with the setOnClickLisner

        val cameraOpenDialog = findViewById<ImageView>(R.id.cameraAdd)
        cameraOpenDialog.setOnClickListener {
            val customDialog = Dialog(this@Update_Dish_Activity)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))   // it is copyed
            val viewIng = layoutInflater.inflate(R.layout.pop_up_dialog, null)
            customDialog.setContentView(viewIng)
            customDialog.show()

            val OpenCamera = viewIng.findViewById<ImageView>(R.id.cameraOpenCamera)
            OpenCamera.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    // asking permission for android version greater than Marshmello

                    Dexter.withContext(this).withPermission(
                            android.Manifest.permission.CAMERA
                    ).withListener(object : PermissionListener {
                        override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                            val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            startActivityForResult(intentCamera, REQUEST_CODE_Camera)
                            customDialog.dismiss()
                            cameraOpenDialog.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_image_to_edit))


                        }

                        override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                            Alertdialog("if you want to take your Dish photos from your camera you please allow the permission" +
                                    "if you are not enable to take photos from your camera go to setting," +
                                    "this Application setting , Permission to take photos and videos'", customDialog.dismiss())
                        }

                        override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?, token: PermissionToken?) {
                            token?.continuePermissionRequest()
                        }

                    })
                    // premission code for Camera end here


                } else {
                    val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intentCamera, REQUEST_CODE_Camera)
                    customDialog.dismiss()
                }
            }

            val OpenGallary = viewIng.findViewById<ImageView>(R.id.openGallary)
            OpenGallary.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Dexter.withContext(this).withPermission(
                            android.Manifest.permission.READ_EXTERNAL_STORAGE
                    ).withListener(object : PermissionListener {
                        override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                            val intentGallary = Intent(Intent.ACTION_PICK)
                            intentGallary.type = "image/*"
                            startActivityForResult(intentGallary, REQUEST_CODE_Gallary)
                            customDialog.dismiss()
                            cameraOpenDialog.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_image_to_edit))

                        }

                        override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                            Alertdialog("if you want to take,your Dish photo from your gallary please" +
                                    "allow the permssion.if you are not enable to take photos from your Gallary go to setting, " +
                                    "this Application setting , Permission of your files and photos' ", customDialog.dismiss())
                        }

                        override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?, token: PermissionToken?) {
                            token?.continuePermissionRequest()
                        }

                    })
                } else {
                    val intentGallary = Intent(Intent.ACTION_PICK)
                    intentGallary.type = "image/*"
                    startActivityForResult(intentGallary, REQUEST_CODE_Gallary)
                    customDialog.dismiss()
                    cameraOpenDialog.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_image_to_edit))

                }
                // premission code for Gallary end here

            }

        }

//        etTitle = findViewById<EditText>(R.id.DishName)

        // all EditTexts in this add UpdataDish Activity


        EDName = findViewById(R.id.DishName)
        EDIngrediance = findViewById(R.id.ingrediance)
        EDMakingSteps = findViewById(R.id.MakingSteps)
        EDWhereThisDishISPopular = findViewById(R.id.whereThisDishIsPopular)

        etType = findViewById<EditText>(R.id.EDType)
        etType.setOnClickListener{
            SelectItemDialog("dish Type",Constants.DishTypes(),Constants.DishType)

        }

        etCatogary = findViewById<EditText>(R.id.EDCatagory)
        etCatogary.setOnClickListener{
            SelectItemDialog("Dish Category",Constants.DishCategoiry(),Constants.DishCatogoriy)
        }

        etTime = findViewById<EditText>(R.id.DishTimeED)
        etTime.setOnClickListener{
            SelectItemDialog("Time to Premare this Dish",Constants.DishCookingTime(),Constants.DishCookingTime)
        }

        btnSubmit = findViewById<Button>(R.id.btnSub)
        btnSubmit.setOnClickListener{
            val nameText = EDName.text.toString().trim{it <= ' '}
            val NameIngrediancce = EDIngrediance.text.toString().trim{it <= ' '}
            val nameMakingSteps = EDMakingSteps.text.toString().trim{it <= ' '}
            val nameTime = etTime.text.toString().trim{it <= ' '}
            val nameCatagory = etCatogary.text.toString().trim{it <= ' '}
            val namedType = etType.text.toString().trim{it <= ' '}
            val nameWhereTHisDish = EDWhereThisDishISPopular.text.toString().trim{it <= ' '}

            when {
                TextUtils.isEmpty(nameText) -> Snackbar.make(it,"Select Dish Name",Snackbar.LENGTH_LONG).show()

                TextUtils.isEmpty(iv_ImagePath) -> Snackbar.make(it,"Select Dish Image",Snackbar.LENGTH_LONG).show()

                TextUtils.isEmpty(NameIngrediancce) -> Snackbar.make(it,"Select Dish Ingrediance",Snackbar.LENGTH_LONG).show()

                TextUtils.isEmpty(nameMakingSteps) -> Snackbar.make(it,"Enter Dish Making Steps",Snackbar.LENGTH_LONG).show()

                TextUtils.isEmpty(nameTime) -> Snackbar.make(it,"Enter,Time to Prepare this Dish",Snackbar.LENGTH_LONG).show()

                TextUtils.isEmpty(nameCatagory) -> Snackbar.make(it,"Select Dish Catagory",Snackbar.LENGTH_LONG).show()

                TextUtils.isEmpty(namedType) -> Snackbar.make(it,"Select Dish Type",Snackbar.LENGTH_LONG).show()

                TextUtils.isEmpty(nameWhereTHisDish) -> Snackbar.make(it,"Select Where this Dish is Popular",Snackbar.LENGTH_LONG).show()



            }
            KeyboardView.HAPTIC_FEEDBACK_ENABLED
        }



    } // onCreateMethord

    private fun Alertdialog(message: String, dismiss: Unit) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Go To App Settings") { dialog, which ->
            try {
                val goToSetting = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", packageName, null)
                goToSetting.data = uri
                startActivity(goToSetting)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Not able to Visit your setting! Please try it your self.", Toast.LENGTH_LONG).show()
            }

        }
        alertDialog.setNegativeButton("ok") { dialog, which ->
            dismiss
        }
        alertDialog.create()
    }
     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imageAddingImage = findViewById<ImageView>(R.id.imageAddingImage)
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_Camera) {
                data?.let {

                }
                val tumnail: Bitmap = data!!.extras!!.get("data") as Bitmap
                // using glide moudule to set image
                Glide
                        .with(this)
                        .load(tumnail)
                        .error(R.drawable.ic_baseline_camera_alt_24)
                        .into(imageAddingImage)
                iv_ImagePath = saveImageToExternalStorage(tumnail)


            }

            if (requestCode == REQUEST_CODE_Gallary)
                data?.let {
                    val tumnailGallary = data.data
                    Glide
                         .with(this)
                         .load(tumnailGallary)
                         .diskCacheStrategy(DiskCacheStrategy.ALL)
                         .listener(object : RequestListener<Drawable>{
                                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                                    Toast.makeText(this@Update_Dish_Activity,"Loading failed",Toast.LENGTH_LONG).show()
                                    return false
                                }

                                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                                    resource?.let {
                                        val bitmap : Bitmap = resource.toBitmap()
                                        iv_ImagePath = saveImageToExternalStorage(bitmap = bitmap)

                                    }
                                    Log.i("TAG","$iv_ImagePath")

                                    return false
                                }

                            })
                            .error(R.drawable.ic_baseline_camera_alt_24)
                            .into(imageAddingImage)
                }
        }
    }

    public fun SetClickEventToSelectionDialog(item : String , selection : String){
        when(selection){
            Constants.DishType -> {
                customDialog.dismiss()
                etType.setText(item)

            }
            Constants.DishCatogoriy -> {
                customDialog.dismiss()
                etCatogary.setText(item)

            }
            Constants.DishCookingTime -> {
                customDialog.dismiss()
                etTime.setText(item)

            }
        }
    }

    // creating a Directory and storeing FavDish Images in  a

    private fun saveImageToExternalStorage(bitmap : Bitmap): String {
        val waper: ContextWrapper = ContextWrapper(this.applicationContext)
        var file = waper.getDir(DIRECTORY_NAME, Context.MODE_PRIVATE)
        file = File(file, "${UUID.randomUUID()}.jpg")

        try {

            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()


        }catch (e:IOException){
            val AD = AlertDialog.Builder(this.applicationContext)
            AD.setMessage("oops Someting went Wrong! Please try again after a while")
            AD.setPositiveButton("Ok"){dialog,hf ->

            }
            AD.create()
        }
        return file.absolutePath
    }

    companion object {
        private const val REQUEST_CODE_Camera = 4
        private const val REQUEST_CODE_Gallary = 45
        private const val DIRECTORY_NAME = "FavDish"
    }

    private fun SelectItemDialog(title : String , itemList : ArrayList<String> , selection : String){
         customDialog = Dialog(this)
        val layout = layoutInflater.inflate(R.layout.dialog_select_type,null)
        val listText = layout.findViewById<TextView>(R.id.TVListName)

        customDialog.setContentView(layout)

        listText.setText(title)

        val RV = layout.findViewById<RecyclerView>(R.id.RecycleView)
        RV.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(this , itemList, selection)
        RV.adapter = adapter
        customDialog.show()
    }

}// class
