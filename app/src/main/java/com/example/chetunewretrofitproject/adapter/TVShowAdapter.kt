package com.example.chetunewretrofitproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutTvShowViewBinding
import com.example.chetunewretrofitproject.model.TVShowsListItem
import com.example.chetunewretrofitproject.model.TvShowListItem
import com.squareup.picasso.Picasso

class TVShowAdapter(private val tvShowList: List<TvShowListItem>, private val context: Context) :
    RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {
    class TVShowViewHolder(val binding: CustomLayoutTvShowViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val binding: CustomLayoutTvShowViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_layout_tv_show_view, parent, false
        )
        return TVShowViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return tvShowList.size
    }


    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val listShow = tvShowList[position]
        val isAdult: Boolean = false
        if (!isAdult) {
            holder.binding.tvShowAdult.text = "A"
        } else {
            holder.binding.tvShowAdult.text = ""
        }
        holder.binding.apply {
            tvShowName.text = listShow.originalName
            val urlBackdroopPath: String = "https://image.tmdb.org/t/p/w500" + listShow.backdropPath
            Picasso.with(context).load(urlBackdroopPath).into(imgTvShowBackdropPath)
            tvShowPopularity.text = listShow.popularity.toString()
            tvShowOverview.text = listShow.overview
            val urlPosterPath: String = "https://image.tmdb.org/t/p/w500" + listShow.posterPath
            Picasso.with(context).load(urlPosterPath).into(imgTvShowPosterPath)
            tvShowFirstAirDate.text = listShow.firstAirDate

        }
    }
}