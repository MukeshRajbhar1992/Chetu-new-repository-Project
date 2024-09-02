package com.example.chetunewretrofitproject.modules

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.UsersAdapter
import com.example.chetunewretrofitproject.databinding.ActivityUserBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: UsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        supportActionBar?.title = "USERS"
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getUsers().observe(this, Observer {
            Log.d("usersDataResponse", ":" + Gson().toJson(it))

            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = UsersAdapter(it, this)
            binding.recyclerView.adapter = adapter

        })

    }
}