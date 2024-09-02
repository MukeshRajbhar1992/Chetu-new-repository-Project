package com.example.chetunewretrofitproject.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.ApiAdapter
import com.example.chetunewretrofitproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: ApiAdapter
    val list:List<String> = listOf("JsonPlaceHolder","FakeStore","Quotes","Tmdb")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        supportActionBar?.title="MainActivity"
        binding.recyclerView.layoutManager =GridLayoutManager(this,2)
        adapter = ApiAdapter(list,this)
        binding.recyclerView.adapter = adapter


    }
}