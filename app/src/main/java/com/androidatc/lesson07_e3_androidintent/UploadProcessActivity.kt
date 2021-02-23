package com.androidatc.lesson07_e3_androidintent

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.upload_process.*

class UploadProcessActivity : AppCompatActivity() {

    var progressBarStatus = 0
    var rate = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_process)

        var message = intent.getStringExtra("caption")
        CaptionText.text = "Caption : " + message

        StopUpload.setOnClickListener {
                view -> Thread(Runnable {
            while (progressBarStatus < 100) {
                try {
                    rate += 10
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                progressBarStatus = rate
                progressBar.progress = progressBarStatus
            }

            progressBar.setVisibility(ProgressBar.INVISIBLE)
        }).start()
        }
    }
}