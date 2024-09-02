package com.example.chetunewretrofitproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.OnSetOnClickListener
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutPopularPersonViewBinding
import com.example.chetunewretrofitproject.model.PopularPersonListItem
import com.squareup.picasso.Picasso

class PopularPersonAdapter(
    private val personList: List<PopularPersonListItem>,
    private val context: Context
) : RecyclerView.Adapter<PopularPersonAdapter.PopularPersonViewHolder>() {
    class PopularPersonViewHolder(val binding: CustomLayoutPopularPersonViewBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularPersonViewHolder {
        val binding: CustomLayoutPopularPersonViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_layout_popular_person_view, parent, false
        )
        return PopularPersonViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return personList.size
    }


    override fun onBindViewHolder(holder: PopularPersonViewHolder, position: Int) {
        val listPerson = personList[position]
        val isAdult: Boolean = false
        holder.binding.apply {
            if (!isAdult) {
                tvPersonAdulte.text = "A"
            } else {
                tvPersonAdulte.text = ""
            }

            tvPersonActing.text = listPerson.knownForDepartment
            tvPersonName.text = listPerson.originalName
            tvPersonPularity.text = listPerson.name

            val urlProfilePath: String = "https://image.tmdb.org/t/p/w500" + listPerson.profilePath
            Picasso.with(context).load(urlProfilePath).into(personProfilePath)
//            holder.itemView.setOnClickListener() {
//                onSetOnClickListener.onItemClick(position,listPerson)
//            }

        }
    }
}