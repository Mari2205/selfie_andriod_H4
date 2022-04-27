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



/*    @Throws(IOException::class)
    fun createImageFile(): File {
//        val time = LocalDateTime.now()
//        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//        val formatted = time.format(formatter)

        val timeStamp = "2022-04-27 13:25"

        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        Log.d("path", "the path is: $storageDir")
        return File.createTempFile(
            "JPEG_${timeStamp}_", *//* prefix *//*
            ".jpg", *//* suffix *//*
            storageDir *//* directory *//*
        ).apply {
            currentPhotoPath = absolutePath
        }
    }*/

//    private fun setPic() {
//        val imageView = findViewById<ImageView>(R.id.imageView_picture)
//        // Get the dimensions of the View
//        val targetW: Int = imageView.width
//        val targetH: Int = imageView.height
//
//        val bmOptions = BitmapFactory.Options().apply {
//            // Get the dimensions of the bitmap
//            inJustDecodeBounds = true
//
////            BitmapFactory.decodeFile(currentPhotoPath, bmOptions)
//
//            val photoW: Int = outWidth
//            val photoH: Int = outHeight
//
//            // Determine how much to scale down the image
//            val scaleFactor: Int = Math.max(1, Math.min(photoW / targetW, photoH / targetH))
//
//            // Decode the image file into a Bitmap sized to fill the View
//            inJustDecodeBounds = false
//            inSampleSize = scaleFactor
//            inPurgeable = true
//        }
//        BitmapFactory.decodeFile(currentPhotoPath, bmOptions)?.also { bitmap ->
//            imageView.setImageBitmap(bitmap)
//        }
//    }
//
//
//    fun saveMediaToStorage(bitmap: Bitmap) {
//        //Generating a file name
//        val filename = "${System.currentTimeMillis()}.jpg"
//
//        //Output stream
//        var fos: OutputStream? = null
//
//        //For devices running android >= Q
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            //getting the contentResolver
//
//            contentResolver?.also { resolver ->
//
//                //Content resolver will process the contentvalues
//                val contentValues = ContentValues().apply {
//
//                    //putting file information in content values
//                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
//                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
//                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
//                }
//
//                //Inserting the contentValues to contentResolver and getting the Uri
//                val imageUri: Uri? =
//                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
//
//                //Opening an outputstream with the Uri that we got
//                fos = imageUri?.let { resolver.openOutputStream(it) }
//            }
//        } else {
//            //These for devices running on android < Q
//            //So I don't think an explanation is needed here
//            val imagesDir =
//                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
//            val image = File(imagesDir, filename)
//            fos = FileOutputStream(image)
//        }
//
//        fos?.use {
//            //Finally writing the bitmap to the output stream that we opened
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
//            //applicationContext.ttoast("Saved to Photos")
//        }
//    }
//
//
//
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