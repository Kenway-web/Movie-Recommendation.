package com.example.movierecommendation.data.model.movie


import com.example.movierecommendation.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>

)