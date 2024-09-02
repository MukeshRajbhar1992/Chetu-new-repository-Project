package com.example.chetunewretrofitproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutPhotosViewBinding
import com.example.chetunewretrofitproject.model.PhotosListItem
import com.squareup.picasso.Picasso

class PhotosAdapter(private val photosList: List<PhotosListItem>, private val context: Context) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    class PhotosViewHolder(val binding: CustomLayoutPhotosViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding: CustomLayoutPhotosViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_layout_photos_view,
            parent,
            false
        )
        return PhotosViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val listPhotos = photosList[position]

        holder.binding.apply {
            photosId.text = listPhotos.id.toString()
            photosTitle.text = listPhotos.title
            photosThumnailUrl.text = listPhotos.thumbnailUrl

            val imagedata: String = "https://via.placeholder.com/600/92c952" + listPhotos.url
            Picasso.with(context)
                .load(imagedata)
                .into(holder.binding.photosImage);

        }

    }
}