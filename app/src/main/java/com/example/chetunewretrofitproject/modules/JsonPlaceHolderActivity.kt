package com.example.chetunewretrofitproject.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.adapter.JsonAdapter
import com.example.chetunewretrofitproject.databinding.ActivityJsonPlaceHolderBinding

class JsonPlaceHolderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJsonPlaceHolderBinding
    private lateinit var adapter: JsonAdapter
    val list: List<String> = listOf("POSTS", "PHOTOS", "ALBUM", "COMMENTS", "USER", "TODO")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title="JsonPlaceHolderActivity"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_json_place_holder)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = JsonAdapter(list, this)
        binding.recyclerView.adapter = adapter

    }
}