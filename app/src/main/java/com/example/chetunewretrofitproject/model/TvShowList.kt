package com.example.chetunewretrofitproject.model


import com.google.gson.annotations.SerializedName

 data class TvShowList(

    @SerializedName("results")
    val results: ArrayList<TvShowListItem> = ArrayList<TvShowListItem>()


)