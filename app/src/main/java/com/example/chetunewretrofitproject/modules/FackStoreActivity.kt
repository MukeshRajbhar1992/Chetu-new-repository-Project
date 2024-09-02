package com.example.chetunewretrofitproject.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chetunewretrofitproject.R

class FackStoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fack_store)
        supportActionBar?.title="FackStoreActivity"
    }
}