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
import com.example.chetunewretrofitproject.Constants
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.PopularPersonAdapter
import com.example.chetunewretrofitproject.databinding.ActivityPopularPersonBinding
import com.example.chetunewretrofitproject.viewmodel.MainViewModel
import com.google.gson.Gson

class PopularPersonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPopularPersonBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter:PopularPersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_popular_person)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        supportActionBar?.title = "Popular Person"
        binding.recyclerView.layoutManager =LinearLayoutManager(this)
        viewModel.getPopularPerson(Constants.key).observe(this, Observer {
            Log.d("popular person","Response"+ Gson().toJson(it))
            adapter=PopularPersonAdapter(it,this)
            binding.recyclerView.adapter=adapter
        })


    }
}