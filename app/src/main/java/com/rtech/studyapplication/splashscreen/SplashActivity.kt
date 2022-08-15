package com.rtech.studyapplication.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rtech.studyapplication.R
import com.rtech.studyapplication.localmodule.view.MyActivity
import kotlinx.android.synthetic.main.activity_splash.splashText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SplashActivity : AppCompatActivity() {

    lateinit var finishJob: Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashText.text = "Hello Captain"
        finishJob = GlobalScope.launch {
            try {
                delay(5000)
                startOtherActivity()
            } catch (exc: Exception) {
                Log.d("TAG", "onCreate: Coroutine intrupted")
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishJob.cancel()
    }

    private fun startOtherActivity() {
        startActivity(Intent(this, MyActivity::class.java))
        finish()
    }
}