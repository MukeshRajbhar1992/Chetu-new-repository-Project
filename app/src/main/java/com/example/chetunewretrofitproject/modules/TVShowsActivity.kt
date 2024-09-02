package com.example.chetunewretrofitproject.modules

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chetunewretrofitproject.Constants
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.TVShowAdapter
import com.example.chetunewretrofitproject.databinding.ActivityTvshowsBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class TVShowsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvshowsBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: TVShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshows)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        supportActionBar?.title = "TVShows"
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getTVShows(Constants.key).observe(this, Observer {
            Log.d("tvShows","Response"+Gson().toJson(it))
            adapter = TVShowAdapter(it,this)
            binding.recyclerView.adapter = adapter
        })

    }
}