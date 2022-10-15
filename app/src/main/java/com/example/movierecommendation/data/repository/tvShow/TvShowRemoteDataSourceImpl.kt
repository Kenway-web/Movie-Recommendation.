package com.example.movierecommendation.data.repository.tvShow

import com.example.movierecommendation.data.api.TMDBService
import com.example.movierecommendation.data.model.movie.MovieList
import com.example.movierecommendation.data.model.tvshow.TvShowList
import com.example.movierecommendation.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDatasource {


    override suspend fun getTvShows(): Response<TvShowList> =tmdbService.getPopularTvShows(apiKey)


}