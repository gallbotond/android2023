package com.example.foodapp

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.foodapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(TAG, "onCreate: SplashActivity created.")

//        val binding = ActivitySplashBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("message", "Hello from Splash!")
//        startActivity(intent)

        // Use a HandlerThread to create a background thread
        val handlerThread = HandlerThread("SplashHandlerThread", -10)
        handlerThread.start() // Create a Handler on the new HandlerThread
        val handler = Handler(handlerThread.looper)
        val SPLASH_TIME_OUT = 3000L

        handler.postDelayed({
        // Navigate to MainActivity after the delay
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish() },
        SPLASH_TIME_OUT)
    }

}