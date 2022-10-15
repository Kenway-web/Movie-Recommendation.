package com.example.movierecommendation.domain.repository

import com.example.movierecommendation.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows():List<TvShow>
}