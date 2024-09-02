package com.example.chetunewretrofitproject.modules

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.PostAdapter
import com.example.chetunewretrofitproject.databinding.ActivityPostBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        supportActionBar?.title = "POSTS"
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        viewModel.getPosts().observe(this, Observer {
            adapter = PostAdapter(it,this)
            Log.d("dataapiresponse",":"+  Gson().toJson(it))
            binding.recyclerView.adapter = adapter
        })

    }
}