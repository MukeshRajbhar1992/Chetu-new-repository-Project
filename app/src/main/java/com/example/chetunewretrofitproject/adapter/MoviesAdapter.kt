package com.example.chetunewretrofitproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutMoviesViewBinding
import com.example.chetunewretrofitproject.model.MoviesListItem
import com.squareup.picasso.Picasso

class MoviesAdapter(
    private val moviesList: ArrayList<MoviesListItem>,
    private val context: Context
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    class MoviesViewHolder(val binding: CustomLayoutMoviesViewBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding: CustomLayoutMoviesViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_layout_movies_view, parent, false
        )
        return MoviesViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return moviesList.size
    }


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val listMovies = moviesList[position]
        val isAdult: Boolean = false
        if (!isAdult) {
            holder.binding.tvAdulte.text = "A"
        } else {
            holder.binding.tvAdulte.text = ""
        }

        holder.binding.apply {
            tvTitle.text = listMovies.title
            tvOriginalLanguage.text = listMovies.originalLanguage
            tvPopularity.text = listMovies.popularity.toString()
            tvOriginalTitle.text = listMovies.originalTitle
            tvOverview.text =listMovies.overview
            val urlImaige: String = "https://image.tmdb.org/t/p/w500" + listMovies.backdropPath
            Picasso.with(context).load(urlImaige).into(imageBackdropPath)
            val posterImaige: String = "https://image.tmdb.org/t/p/w500" + listMovies.posterPath
            Picasso.with(context).load(posterImaige).into(imagePosterPath)
//            imageBackdropPath
//            backdropPath
        }

    }
}