package com.androidatc.lesson07_e3_androidintent

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_third.*

class UploadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
    }


    fun GallerySnack(view: View) {
        var SnackB: Snackbar = Snackbar.make(findViewById(R.id.constraintLayout)
            ,"You Choose From Gallery",Snackbar.LENGTH_LONG).setAction("Undo") {}

        SnackB.setActionTextColor(Color.RED)
        SnackB.show()
    }


    fun upload(view: View) {
        val SaveAlert= AlertDialog.Builder(this)

        SaveAlert.setTitle("Upload")
        SaveAlert.setMessage("Are you sure you want to upload")

        SaveAlert.setPositiveButton("Yes") {
                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Uploaded",
            Toast.LENGTH_LONG).show()
            var intent = Intent(this,UploadProcessActivity::class.java)
            startActivity(intent)
        }
        SaveAlert.setNegativeButton("No") {

                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Upload cancelled",
            Toast.LENGTH_LONG).show()

        }

        SaveAlert.show()
    }


    fun go2secondActivity(view: View){
        var intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }

}