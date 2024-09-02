package com.example.chetunewretrofitproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutAlbumViewBinding
import com.example.chetunewretrofitproject.model.AlbumListItem

class AlbumsAdapter(private val albumList: List<AlbumListItem>) :
    RecyclerView.Adapter<AlbumsAdapter.albumsViewHolder>() {
    class albumsViewHolder(val binding: CustomLayoutAlbumViewBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): albumsViewHolder {
        val binding: CustomLayoutAlbumViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_layout_album_view, parent, false
        )
        return albumsViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return albumList.size
    }


    override fun onBindViewHolder(holder: albumsViewHolder, position: Int) {
        val listalbum = albumList[position]
        holder.binding.apply {
            albumsId.text = listalbum.id.toString()
            albumsTitle.text = listalbum.title
        }
    }
}