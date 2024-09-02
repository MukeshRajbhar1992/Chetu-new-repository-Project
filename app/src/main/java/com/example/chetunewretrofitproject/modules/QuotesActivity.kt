package com.example.chetunewretrofitproject.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chetunewretrofitproject.R

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        supportActionBar?.title="QUOTES"
    }
}