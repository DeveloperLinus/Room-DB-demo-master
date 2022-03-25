package com.itlong.room.demo1

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.itlong.room.R
import com.itlong.room.databinding.ActDemo1MainBinding

class MainActivity : Activity() {
    private lateinit var binding: ActDemo1MainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.act_demo1_main)
        initView()
    }

    private fun initView() {
        val uid = 20220325
        binding.btnInsertUser.setOnClickListener {
            UserManager.insert(User(uid, "hu", "qinghui"))
        }
        binding.btnQueryUser.setOnClickListener {
            val user = UserManager.query(uid)
            binding.tvQueryUser.text = user?.toString()
        }
        binding.btnDeleteUser.setOnClickListener {
            UserManager.delete(uid)
        }
    }
}