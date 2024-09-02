package com.example.chetunewretrofitproject.modules

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.PhotosAdapter
import com.example.chetunewretrofitproject.databinding.ActivityPhotosBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class PhotosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhotosBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photos)
        supportActionBar?.title = "PHOTOS"
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getPhotos().observe(this, Observer {
            adapter = PhotosAdapter(it, this)
            Log.d("dataapiresponse",":"+  Gson().toJson(it))
            binding.recyclerView.adapter = adapter

        })
    }
}