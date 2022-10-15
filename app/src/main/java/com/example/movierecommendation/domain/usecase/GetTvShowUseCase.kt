package com.example.movierecommendation.domain.usecase

import com.example.movierecommendation.data.model.tvshow.TvShow
import com.example.movierecommendation.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowrepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowrepository.getTvShows()
}