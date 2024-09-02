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
import com.example.chetunewretrofitproject.adapter.CommentsAdapter
import com.example.chetunewretrofitproject.databinding.ActivityCommentsBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class CommentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentsBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CommentsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_comments)
        supportActionBar?.title="COMMENTS"
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getComments().observe(this, Observer {
            Log.d("dataResponseComments",":"+Gson().toJson(it))
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = CommentsAdapter(it)
            binding.recyclerView.adapter =adapter
        })
    }
}