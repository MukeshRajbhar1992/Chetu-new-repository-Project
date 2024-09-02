package com.example.chetunewretrofitproject.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.InvalidationTracker
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.TmdpAdapter
import com.example.chetunewretrofitproject.databinding.ActivityTmdbactivityBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class TMDBActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTmdbactivityBinding

    private lateinit var adapter: TmdpAdapter
    val list :List<String> = listOf("movies","tvShow","person")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tmdbactivity)
        supportActionBar?.title = "TMDBActivity"

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TmdpAdapter(list,this)
        binding.recyclerView.adapter = adapter


    }
}