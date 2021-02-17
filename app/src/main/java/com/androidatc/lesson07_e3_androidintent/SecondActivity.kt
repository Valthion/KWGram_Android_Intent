package com.androidatc.lesson07_e3_androidintent

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var message = intent.getStringExtra("name")
        HelloMessage_ID.text = message
    }

    fun update(view: View) {
        val UpdateAlert= AlertDialog.Builder(this)

        UpdateAlert.setTitle("Update Status")
        UpdateAlert.setMessage("Are you sure you want to save changes?")

        UpdateAlert.setPositiveButton("Yes") {
                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Updated",
            Toast.LENGTH_LONG).show()
        }
        UpdateAlert.setNegativeButton("No") {
                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Canceled",
            Toast.LENGTH_LONG).show()
        }

        UpdateAlert.show()
    }

    fun go2dmActivity(view: View) {
        var intent = Intent(this,DMActivity::class.java)
        startActivity(intent)
    }

    fun go2searchActivity(view: View){
        var intent = Intent(this,SearchActivity::class.java)
        startActivity(intent)
    }

    fun go2uploadActivity(view: View){
        var intent = Intent(this,UploadActivity::class.java)
        startActivity(intent)
    }
}
