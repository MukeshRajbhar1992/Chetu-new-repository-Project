package com.example.chetunewretrofitproject.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomlayoutJsonViewBinding
import com.example.chetunewretrofitproject.modules.AlbumActivity
import com.example.chetunewretrofitproject.modules.CommentsActivity
import com.example.chetunewretrofitproject.modules.PhotosActivity
import com.example.chetunewretrofitproject.modules.PostActivity
import com.example.chetunewretrofitproject.modules.TodoActivity
import com.example.chetunewretrofitproject.modules.UserActivity

class JsonAdapter(private val jsonList: List<String>, private val context: Context) :
    RecyclerView.Adapter<JsonAdapter.JsonViewHolder>() {
    class JsonViewHolder(var binding: CustomlayoutJsonViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonViewHolder {
        val binding: CustomlayoutJsonViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.customlayout_json_view,
            parent,
            false
        )
        return JsonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jsonList.size
    }

    override fun onBindViewHolder(holder: JsonViewHolder, position: Int) {
        holder.binding.tvJsonName.text = jsonList[position]
        holder.itemView.setOnClickListener() {
            when (position) {
                0 -> {
                    val intent = Intent(context as Activity, PostActivity::class.java)
                    context.startActivities(arrayOf(intent))

                }

                1 -> {
                    val intent = Intent(context as Activity, PhotosActivity::class.java)
                    context.startActivities(arrayOf(intent))

                }

                2 -> {
                    val intent = Intent(context as Activity, AlbumActivity::class.java)
                    context.startActivities(arrayOf(intent))

                }

                3 -> {
                    val intent = Intent(context as Activity, CommentsActivity::class.java)
                    context.startActivities(arrayOf(intent))

                }

                4 -> {
                    val intent = Intent(context as Activity, UserActivity::class.java)
                    context.startActivities(arrayOf(intent))

                }

                5 -> {
                    val intent = Intent(context as Activity, TodoActivity::class.java)
                    context.startActivities(arrayOf(intent))

                }

            }
        }

    }
}