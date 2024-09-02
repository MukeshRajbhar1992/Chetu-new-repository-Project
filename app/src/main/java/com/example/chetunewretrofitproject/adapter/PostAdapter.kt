package com.example.chetunewretrofitproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.PostCustomLayoutViewBinding
import com.example.chetunewretrofitproject.model.PostsListItem

class PostAdapter(private val postList: List<PostsListItem>, private val context: Context) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(val binding: PostCustomLayoutViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding: PostCustomLayoutViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.post_custom_layout_view, parent, false
        )
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val listPost = postList[position]
        holder.binding.apply {
            postId.text = listPost.id.toString()
            postTitle.text = listPost.title
            postBody.text = listPost.body
        }
    }
}