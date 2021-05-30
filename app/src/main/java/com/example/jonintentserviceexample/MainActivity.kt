package com.example.jonintentserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.jonintentserviceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            btn.setOnClickListener {_->
                val text = etTxt.text.toString()
                var serviceIntent = Intent(this@MainActivity, ExampleJobIntentService::class.java)
                serviceIntent.putExtra("inputString", text)
                ExampleJobIntentService.enqueueWork(this@MainActivity, serviceIntent)
            }
        }
    }
}