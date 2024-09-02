package com.example.chetunewretrofitproject

import com.example.chetunewretrofitproject.model.PopularPersonListItem

interface OnSetOnClickListener {
    fun onItemClick(position: Int, listPerson: PopularPersonListItem)
}
