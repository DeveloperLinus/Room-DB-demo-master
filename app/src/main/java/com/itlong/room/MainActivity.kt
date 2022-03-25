package com.itlong.room

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.itlong.room.databinding.ActMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.act_main)
        binding.btnDemo1.setOnClickListener {
            startActivity(Intent(this, com.itlong.room.demo1.MainActivity::class.java))
        }
        binding.btnDemo2.setOnClickListener {
            startActivity(Intent(this, com.itlong.room.demo2.MainActivity::class.java))
        }
    }
}