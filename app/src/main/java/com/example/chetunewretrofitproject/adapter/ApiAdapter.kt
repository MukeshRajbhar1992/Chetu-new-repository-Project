package com.example.chetunewretrofitproject.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomlayoutApiViewBinding
import com.example.chetunewretrofitproject.modules.FackStoreActivity
import com.example.chetunewretrofitproject.modules.JsonPlaceHolderActivity
import com.example.chetunewretrofitproject.modules.QuotesActivity
import com.example.chetunewretrofitproject.modules.TMDBActivity

class ApiAdapter(private val apilist: List<String>, private val context: Context) :
    Adapter<ApiAdapter.ApiViewHolder>() {
    class ApiViewHolder(val customlayoutApiViewBinding: CustomlayoutApiViewBinding) :
        RecyclerView.ViewHolder(customlayoutApiViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val customlayoutApiViewBinding: CustomlayoutApiViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.customlayout_api_view, parent, false
        )
        return ApiViewHolder(customlayoutApiViewBinding)
    }

    override fun getItemCount(): Int {
        return apilist.size
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        holder.customlayoutApiViewBinding.tvApiname.text = apilist[position]
        holder.itemView.setOnClickListener {
            when (position) {
                0 -> {
                    val intent = Intent(context as Activity, JsonPlaceHolderActivity::class.java)
                    context.startActivities(arrayOf(intent))

                }

                1 -> {
                    val intent = Intent(context as Activity, FackStoreActivity::class.java)
                    context.startActivity(intent)

                }

                2 -> {
                    val intent = Intent(context as Activity, QuotesActivity::class.java)
                    context.startActivity(intent)
                }

                3 -> {
                    val intent = Intent(context as Activity,TMDBActivity::class.java)
                    context.startActivity(intent)
                }

            }
        }
    }
}