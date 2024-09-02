package com.example.chetunewretrofitproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutCommentViewBinding
import com.example.chetunewretrofitproject.model.commentsListItem

class CommentsAdapter(private val commentList: List<commentsListItem>):RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {
    class CommentsViewHolder(val binding: CustomLayoutCommentViewBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val binding:CustomLayoutCommentViewBinding =DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.custom_layout_comment_view,parent,false)
        return CommentsViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return commentList.size
    }


    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val listComments=commentList[position]
        holder.binding.apply {
            commentsId.text = listComments.id.toString()
            commentsName.text = listComments.name
            commentsEmail.text = listComments.email
            commentsBody.text = listComments.body

        }
    }
}