package com.example.movierecommendation.data.repository.tvShow

import com.example.movierecommendation.data.model.movie.MovieList
import com.example.movierecommendation.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}