package com.krsolutions.crossFire

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat

class LauncherActivity : AppCompatActivity() {
    lateinit var btnPlay:Button
    lateinit var btnExit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        btnPlay=findViewById(R.id.btnPlay)
        btnExit=findViewById(R.id.btnExit)
        btnPlay.setOnClickListener {
        val intent=Intent(this@LauncherActivity,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            ActivityCompat.finishAffinity(this@LauncherActivity)
        }
    }
}