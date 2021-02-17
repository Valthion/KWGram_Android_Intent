package com.androidatc.lesson07_e3_androidintent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var message = intent.getStringExtra("name")
        HelloMessage_ID.text = message
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun update(view: View) {
        val UpdateAlert= AlertDialog.Builder(this)

        UpdateAlert.setTitle("Update Status")
        UpdateAlert.setMessage("Are you sure you want to save changes?")

        UpdateAlert.setPositiveButton("Yes") {
                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Updated",
            Toast.LENGTH_LONG).show()
            val id = "updated"

            val name = getString(R.string.abc_action_bar_home_description)

            val description = getString(R.string.abc_action_bar_home_description)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(id, name, importance)

            mChannel.description = description
            mChannel.enableLights(true)

            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)

            val CHANNEL_ID = "updated"

            // Use NotificationCompat.Builder to add the notification objects
            val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_background)
                .setContentTitle("Status Updated")
                .setContentText("Status has been updated!")

            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            mNotificationManager.createNotificationChannel(mChannel)
            mNotificationManager.notify(1, mBuilder.build())
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
