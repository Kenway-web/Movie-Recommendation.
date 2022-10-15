package com.example.movierecommendation.data.api

import com.example.movierecommendation.data.model.artist.ArtistList
import com.example.movierecommendation.data.model.movie.MovieList
import com.example.movierecommendation.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apikey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apikey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apikey: String): Response<ArtistList>


}