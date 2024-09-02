package com.example.chetunewretrofitproject.model

import com.google.gson.annotations.SerializedName

class MoviesList {
    @SerializedName("results")
    val resultsMovies = ArrayList<MoviesListItem>()

}