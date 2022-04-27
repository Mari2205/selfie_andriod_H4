package com.example.selfie_android_h4

import android.R.attr.bitmap
import android.content.ActivityNotFoundException
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*


val REQUEST_IMAGE_CAPTURE = 1
//lateinit var currentPhotoPath: String
lateinit var bitmap_image:Bitmap

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    fun takePicture(view: View) {
//        val REQUEST_IMAGE_CAPTURE = 1
//
//        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
//    }



     fun dispatchTakePictureIntent(view: View) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val imageView_picture = findViewById<ImageView>(R.id.imageView_picture)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap

            imageView_picture.setImageBitmap(imageBitmap)
//            val bitmap_imag:Bitmap = imageBitmap
            bitmap_image = imageBitmap
        }
    }



    /**
     * This metode save an bitmap/image to android gallery
     * @author Marius M. Møller
     * @param view er en knap(save btn) fra xml'en(ui) code
    */
    fun saveImage(view: View){
//
////        val imageView_t = findViewById<ImageView>(R.id.imageView_test)
////        setPic()
////        var temp = createImageFile()

        val savedImageURL: String = MediaStore.Images.Media.insertImage(
            contentResolver,
            bitmap_image,
            "Bird",
            "Image of bird"
        )


        val t = ""
    }
}