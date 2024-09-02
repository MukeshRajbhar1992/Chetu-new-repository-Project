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
import com.example.chetunewretrofitproject.adapter.AlbumsAdapter
import com.example.chetunewretrofitproject.adapter.TodoAdapter
import com.example.chetunewretrofitproject.databinding.ActivityAlbumBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class AlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: AlbumsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_album)
        supportActionBar?.title = "ALBUM"
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getAlbums().observe(this, Observer {
            Log.d("dataAlbumsresponse", ":" + Gson().toJson(it))
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = AlbumsAdapter(it)
            binding.recyclerView.adapter = adapter
        })
    }
}