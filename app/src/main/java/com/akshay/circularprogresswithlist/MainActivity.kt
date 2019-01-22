package com.akshay.circularprogresswithlist

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCountDownTimer(minutes = 1)
    }

    private fun setCountDownTimer(minutes: Int) {
        progressBar.max = minutes * 60 * 1000
        val mCountDownTimer = object : CountDownTimer((minutes * 60 * 1000).toLong(), 1) {
            override fun onTick(millisUntilFinished: Long) {
                progressBar.setProgress(millisUntilFinished.toInt())
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Times Up", Toast.LENGTH_LONG).show()
            }
        }
        mCountDownTimer.start()
    }
}
