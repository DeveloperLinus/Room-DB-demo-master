package com.itlong.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.itlong.room.databinding.ActMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.act_main)
    }
}