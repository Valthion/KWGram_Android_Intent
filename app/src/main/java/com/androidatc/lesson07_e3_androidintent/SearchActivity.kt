package com.androidatc.lesson07_e3_androidintent

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
    }

    fun about(view :View){
        val SaveAlert= AlertDialog.Builder(this)
        SaveAlert.setTitle("Save Picture")
        SaveAlert.setMessage("Are you sure you want save image to Gallery?")
        SaveAlert.setPositiveButton("Yes") {
                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Saved",
            Toast.LENGTH_LONG).show()

        }
        SaveAlert.setNegativeButton("No") {

                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Cancelled",
            Toast.LENGTH_LONG).show()

        }

        SaveAlert.show()
    }
    fun SearchSnack(view: View) {
        var SnackB: Snackbar = Snackbar.make(findViewById(R.id.constraintLayout)
            ,"No internet Connection", Snackbar.LENGTH_LONG).setAction("Retry") {}

        SnackB.setActionTextColor(Color.RED)
        SnackB.show()
    }
}
