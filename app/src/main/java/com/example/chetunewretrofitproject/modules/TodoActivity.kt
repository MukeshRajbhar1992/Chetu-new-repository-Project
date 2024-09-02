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
import com.example.chetunewretrofitproject.adapter.TodoAdapter
import com.example.chetunewretrofitproject.databinding.ActivityTodoBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo)
        supportActionBar?.title = "TODO"
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getTodos().observe(this, Observer {
            Log.d("TodosDataResponse", ":" + Gson().toJson(it))
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = TodoAdapter(it)
            binding.recyclerView.adapter = adapter
        })
    }
}