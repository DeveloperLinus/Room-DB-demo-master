package com.itlong.room.demo2

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.itlong.room.R
import com.itlong.room.databinding.ActDemo2MainBinding

class MainActivity : Activity() {
    private lateinit var binding: ActDemo2MainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.act_demo2_main)
        initView()
    }

    private fun initView() {
        val userId = "20220325"
        binding.btnInsertFace.setOnClickListener {
            val faceEntity = FaceEntity(userId, picPath = "sdcard", picUrl = "face.jpg")
            FaceManager.insertOrReplace(faceEntity)
        }
        binding.btnQueryFace.setOnClickListener {
            val face = FaceManager.queryByUid(userId)
            binding.tvQueryFace.text = face.toString()
        }

        binding.btnDeleteFace.setOnClickListener {
            FaceManager.deleteByUid(userId)
        }

        binding.btnInsertUser1.setOnClickListener {
            val userEntity = UserEntity("huqinghui", "123456")
            val result = UserManager.insert(userEntity)
            Log.d("Room", "插入用户数据成功,result=$result")
        }
    }
}