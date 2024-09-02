package com.example.chetunewretrofitproject.model


import com.google.gson.annotations.SerializedName

data class ListPopularPerson(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results:ArrayList<PopularPersonListItem> = ArrayList<PopularPersonListItem>(),
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)