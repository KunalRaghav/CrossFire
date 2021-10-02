package com.krsolutions.crossFire

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.krsolutions.crossFire.databinding.ActivityMainBinding

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.playButton.setOnClickListener(onMenuListener)
        binding.exitButton.setOnClickListener(onMenuListener)
    }

    private val onMenuListener = View.OnClickListener {
        when(it.id) {
            R.id.playButton->{
                startActivity(Intent(this, QuestionActivity::class.java))
                finish()
            }
            R.id.exitButton->{
                finish()
            }
        }
    }
}