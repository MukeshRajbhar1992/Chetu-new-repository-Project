package com.example.chetunewretrofitproject.modules

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.MoviesAdapter
import com.example.chetunewretrofitproject.databinding.ActivityMoviesBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter :MoviesAdapter
    val key: String = "6172f7b4e175edb6bf01088aebd7e1a7"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)
        supportActionBar?.title = "Movies"

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getMovies(key).observe(this, Observer {
            Log.d("moviesapiresponse", "response" + Gson().toJson(it))
            adapter = MoviesAdapter(it,this)
            binding.recyclerView.adapter =adapter
        })

    }
}