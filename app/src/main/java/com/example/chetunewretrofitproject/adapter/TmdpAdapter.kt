package com.example.chetunewretrofitproject.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutTmdpViewBinding
import com.example.chetunewretrofitproject.modules.MoviesActivity
import com.example.chetunewretrofitproject.modules.PopularPersonActivity
import com.example.chetunewretrofitproject.modules.TVShowsActivity

class TmdpAdapter(private val list: List<String>, private val context: Context) :
    RecyclerView.Adapter<TmdpAdapter.TmdpViewHolder>() {
    class TmdpViewHolder(val binding: CustomLayoutTmdpViewBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TmdpViewHolder {
        val binding: CustomLayoutTmdpViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_layout_tmdp_view,
            parent,
            false
        )
        return TmdpViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: TmdpViewHolder, position: Int) {
        holder.binding.tvJsonName.text = list[position]
        holder.itemView.setOnClickListener() {
            when (position) {
                0 -> {
                    context.startActivity(Intent(context as Activity,MoviesActivity::class.java))
                }

                1 -> {
                    context.startActivity(Intent(context as Activity,TVShowsActivity::class.java))
                }

                2 -> {
                    context.startActivity(Intent(context as Activity,PopularPersonActivity::class.java))
                }
            }
        }
    }
}