package com.itlong.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.itlong.room.databinding.ActMainBinding
import com.itlong.room.demo1.AppDatabaseManager
import com.itlong.room.demo1.User
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var binding: ActMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.act_main)
        binding.btnInsertUser.setOnClickListener {
            launch(Dispatchers.IO) {
                AppDatabaseManager.db.userDao().insertAll(User(1, "huqinghui", "huqh"))
            }
        }
        binding.btnQueryUser.setOnClickListener {
            launch {
                val deferred = async(Dispatchers.IO) {
                    AppDatabaseManager.db.userDao().getAll()
                }
                val user = deferred.await()
                binding.tvQueryUser.text = user.toString()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}