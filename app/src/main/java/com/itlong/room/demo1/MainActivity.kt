package com.itlong.room.demo1

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.itlong.common.utils.RxJava2Helper
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
            RxJava2Helper.getFlowable {
                UserManager.insert(User(uid, "hu", "qinghui"))
            }
        }
        binding.btnQueryUser.setOnClickListener {
            RxJava2Helper.getFlowable {
                UserManager.query(uid)
            }.subscribe { user ->
                binding.tvQueryUser.text = user?.toString()
            }
        }
        binding.btnDeleteUser.setOnClickListener {
            RxJava2Helper.getFlowable {
                UserManager.delete(uid)
            }
        }
    }
}